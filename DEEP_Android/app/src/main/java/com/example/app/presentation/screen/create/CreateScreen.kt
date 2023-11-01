package com.example.app.presentation.screen.create

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import com.example.app.MainActivity
import com.example.app.MainViewModel
import com.example.app.util.TAG
import com.example.app.util.deepFontFamily
import com.example.app.util.shadow
import com.example.deep_android.R
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.window.Dialog
import androidx.core.app.ActivityCompat
import com.example.app.presentation.screen.cardlist.DeepTopBar
import com.example.app.ui.theme.Blue

@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun CreateScreen(navController: NavController){


    val context = LocalContext.current

    var isBitmapRatioOk by remember { mutableStateOf<Boolean>(false) }

//    var image by remember{ mutableStateOf<MultiPart>() }
    var bitmap by remember{ mutableStateOf<Bitmap?>(null) }
    var imageUri by remember{ mutableStateOf<Uri?>(null) }

    val activity = context as? ComponentActivity

    var requestImageFromExternalStorage : ManagedActivityResultLauncher<String,Uri?>? = null

    val scrollState = rememberScrollState()


    requestImageFromExternalStorage = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        if (uri != null) {
            imageUri = uri
        }
    }

    LaunchedEffect(imageUri){
        if(imageUri != null){
            Log.d(TAG,"imageUri - $imageUri")

            bitmap = imageUri!!.uriToBitmap(context)

            Log.d(TAG,"Bitmap height : ${bitmap!!.height}, width : ${bitmap!!.width}")
            val bitmapRatio = bitmap!!.width.toDouble() / bitmap!!.height.toDouble()
            val minRatio = 85.0/55.0
            val maxRaio = 90.0/50.0

            isBitmapRatioOk = (bitmapRatio >= minRatio && bitmapRatio <= maxRaio)

        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        DeepTopBar({}, {})
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
        ){
            CreateView(
                activity,
                requestImageFromExternalStorage,
                bitmap,
                isBitmapRatioOk
            )

            Spacer(
                modifier = Modifier
                    .height(100.dp)
            )

            CreateButton(
                {navController.popBackStack()},
                isBitmapRatioOk
            )
        }
    }

}

@Preview
@Composable
fun PreviewCreateScreen(){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        DeepTopBar({}, {})

        CreateView(
            activity = LocalContext.current as? ComponentActivity,
//            rememberImagePicker(onImage = {}),
            rememberLauncherForActivityResult(ActivityResultContracts.GetContent()){},
            null,
            false
        )

        CreateButton({},false)
    }
}

@Composable
fun CreateView(
    activity: ComponentActivity?,
    requestImageFromExternalStorage : ManagedActivityResultLauncher<String,Uri?>,
    bitmap : Bitmap?,
    isBitmapRatioOk : Boolean
){

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 18.dp)
    ) {
        Text(
            text = "명함 만들기",
            color = Color.Black,
            fontFamily = deepFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(14.dp))

        Image(
            modifier = Modifier
                .shadow(Color(0x16000000), 0.dp, 5.dp, 15.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .clickable {
                    when (activity!!.checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)) {
                        PackageManager.PERMISSION_GRANTED -> {

                            requestImageFromExternalStorage.launch("image/*")
                        }

                        else -> ActivityCompat.requestPermissions(
                            activity,
                            arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                            1
                        )
                    }
                },
            painter =
            if (bitmap == null) painterResource(id = R.drawable.bg_upload_img)
            else BitmapPainter(bitmap.asImageBitmap())
            ,
            contentDescription = "이미지를 넣을 칸입니다",
            contentScale = ContentScale.FillWidth,
        )

        Spacer(modifier = Modifier.height(5.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ){
            Text(
                text = "png 파일, 가로 85~90 : 세로 50~55",
                color =
                if(isBitmapRatioOk) Color.Gray
                else Color.Red,
                fontFamily = deepFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp
            )
        }

        Spacer(modifier = Modifier.height(80.dp))

    }
}

@Composable
fun CreateButton(
    onCreateClick : () -> Unit,
    isBitmapRatioOk: Boolean
){
    Column(
        modifier = Modifier
            .padding(horizontal = 18.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = onCreateClick,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            colors = ButtonDefaults.buttonColors(containerColor = Blue.DeepBlue),
            shape = RoundedCornerShape(16.dp),
            contentPadding = PaddingValues(vertical = 12.dp),
            enabled = isBitmapRatioOk
        ) {
            Text(
                text = "명함 만들기",
                color = Color.White,
                fontFamily = deepFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

    }
}


@RequiresApi(Build.VERSION_CODES.P)
private fun Uri.uriToBitmap(context: Context): Bitmap {
    return when (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
        true -> {
            val source = ImageDecoder.createSource(context.contentResolver, this)
            ImageDecoder.decodeBitmap(source)
        }
        else -> {
            MediaStore.Images.Media.getBitmap(context.contentResolver, this)
        }
    }
}


