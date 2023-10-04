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
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.app.ui.theme.DeepBlue
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

@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun CreateScreen(navController: NavController, mainViewModel: MainViewModel, alert: (@Composable () -> Unit) -> Unit){

    val text by rememberUpdatedState(newValue = mainViewModel.text)
    val textColor by rememberUpdatedState(newValue = mainViewModel.textColor)
    val isButtonEnabled by rememberUpdatedState(newValue = mainViewModel.isButtonEnabled)
    val context = LocalContext.current

    var isShowAlert by remember { mutableStateOf(false) }
    val isSuccessed by rememberUpdatedState(newValue = mainViewModel.isSuccessed)

    val isBitmapRatioOk by rememberUpdatedState(newValue = mainViewModel.isBitmapRatioOk)

//    var image by remember{ mutableStateOf<MultiPart>() }
    var bitmap by remember{ mutableStateOf<Bitmap?>(null) }
    var imageUri by remember{ mutableStateOf<Uri?>(null) }

    val activity = context as? ComponentActivity
    val coroutineScope = rememberCoroutineScope()

    var requestImageFromExternalStorage : ManagedActivityResultLauncher<String,Uri?>? = null


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

            mainViewModel.isBitmapRatioOk = (bitmapRatio >= minRatio && bitmapRatio <= maxRaio)
            mainViewModel.isButtonEnabled = (bitmapRatio >= minRatio && bitmapRatio <= maxRaio) && mainViewModel.isConnected

        }
    }

    LaunchedEffect(isSuccessed) {
        if(isSuccessed != null){
            if (isSuccessed!!) {
                isShowAlert = true
                alert {
                    ConnectDialog(
                        text = "명함 등록에 성공했습니다",
                        onClick = { isShowAlert = false },
                        isShow = isShowAlert
                    )
                }

            } else {
                isShowAlert = true
                alert {
                    ConnectDialog(
                        text = "명함 등록에 실패했습니다",
                        onClick = { isShowAlert = false },
                        isShow = isShowAlert
                    )
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        DeepTopBar({}, {})

        CreateView(
            activity,
//            imagePicker,
            requestImageFromExternalStorage,
            bitmap,
            isBitmapRatioOk
        )

        CreateButton({

            Log.d(TAG, "CreateScreen: intent : ${mainViewModel.intent} ")

            if(mainViewModel.intent != null){
                val ndefMessage =
                    (activity as MainActivity).createNdefMessage("https://www.github.com/PARAOOO")
                (activity as MainActivity).writeNdefMessageToTag(mainViewModel.intent!!, ndefMessage)
            }

        },
        text,textColor, isButtonEnabled)
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
            activity = LocalContext.current as ComponentActivity,
//            rememberImagePicker(onImage = {}),
            rememberLauncherForActivityResult(ActivityResultContracts.GetContent()){},
            null,
            false
        )

        CreateButton({},"", Color.White,true)
    }
}

@Composable
fun DeepTopBar(
    onLogoClick : () -> Unit,
    onCategoryClick : () -> Unit
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 18.dp, vertical = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            modifier = Modifier.height(17.dp),
            painter = painterResource(id = R.drawable.logo_deep),
            contentDescription = "DEEP 로고입니다"
        )

        Image(
            modifier = Modifier.height(17.dp),
            painter = painterResource(id = R.drawable.ic_hamburger),
            contentDescription = "카테고리 버튼입니다"
        )
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
            text = "NFC 태그에 명함 넣기",
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
    text : String,
    textColor : Color,
    isButtonEnabled : Boolean
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
            colors = ButtonDefaults.buttonColors(containerColor = DeepBlue),
            shape = RoundedCornerShape(16.dp),
            contentPadding = PaddingValues(vertical = 12.dp),
            enabled = isButtonEnabled
        ) {
            Text(
                text = "명함 넣기",
                color = Color.White,
                fontFamily = deepFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = text,
            color = textColor,
            fontFamily = deepFontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

    }
}


@Preview
@Composable
fun PreviewDialog(){
    ConnectDialog("명함 등록에 성공했습니다",{},false)
}

@Composable
fun ConnectDialog(
    text : String,
    onClick : () -> Unit,
    isShow : Boolean,
){
    if(isShow){
        Dialog(
            onDismissRequest = onClick,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(horizontal = 30.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(color = Color.White),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = text,
                    color = Color.Black,
                    fontFamily = deepFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 18.sp
                )

                Spacer(modifier = Modifier.height(12.dp))

                TextButton(
                    onClick = onClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(30.dp)
                        .padding(horizontal = 40.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = DeepBlue),
                    shape = RoundedCornerShape(16.dp),
                    contentPadding = PaddingValues(vertical = 0.dp),
                ) {
                    Text(
                        text = "확인",
                        color = Color.White,
                        fontFamily = deepFontFamily,
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

            }
        }
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


