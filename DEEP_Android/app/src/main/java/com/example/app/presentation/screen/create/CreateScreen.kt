package com.example.app.presentation.screen.create

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
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
import androidx.compose.foundation.layout.wrapContentWidth
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
import com.example.app.ui.theme.DeepBlue
import com.example.app.util.TAG
import com.example.app.util.deepFontFamily
import com.example.app.util.shadow
import com.example.deep_android.R
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.window.Dialog
import androidx.core.app.ActivityCompat
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.app.presentation.screen.cardlist.DeepTopBar
import com.example.app.ui.theme.Blue
import com.example.data.network.request.Message
import com.example.domain.model.ClovaOcrDto
import com.example.domain.model.ImageModel
import com.example.domain.model.MessageModel
import com.example.domain.repository.CardRepository
import com.google.accompanist.pager.rememberPagerState
import com.websitebeaver.documentscanner.DocumentScanner
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.parse
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.internal.format
import java.io.ByteArrayOutputStream
import java.io.File
import java.net.URI

@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun CreateScreen(
    navController: NavController,
    viewModel: CreateViewModel = hiltViewModel(),
    mainViewModel : MainViewModel
){

    val isSuccess by rememberUpdatedState(newValue = viewModel.isSuccess)

    var isButtonEnabled by remember { mutableStateOf<Boolean>(false) }

    val dialogState by rememberUpdatedState(newValue = viewModel.dialogState)

    val clovaOcrResult by rememberUpdatedState(newValue = viewModel.ClovaOcrReault)

    LaunchedEffect(isSuccess){
        if(isSuccess != null){
            if (isSuccess!!) {
                navController.popBackStack()
            } else {
                isButtonEnabled = true
            }
        }
    }


    val context = LocalContext.current

    val bitmap by rememberUpdatedState(newValue = mainViewModel.bitmap)
    var imageUri by remember{ mutableStateOf<Uri?>(null) }
    var multipartBody by remember{ mutableStateOf<MultipartBody.Part?>(null) }

    LaunchedEffect(viewModel.ClovaOcrReault){
        Log.d(TAG, "ClovaOcrResult - ${viewModel.ClovaOcrReault}")
    }

    val activity = context as MainActivity

    var requestImageFromExternalStorage : ManagedActivityResultLauncher<String,Uri?>? = null

    val scrollState = rememberScrollState()


    requestImageFromExternalStorage = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        if (uri != null) {
            imageUri = uri
        }
    }

    var requestImage : ManagedActivityResultLauncher<PickVisualMediaRequest,Uri?>? = null

    requestImage = rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
        if (uri != null) {
            imageUri = uri
        }
    }

    if(dialogState){
        Dialog(
            onDismissRequest = {
                viewModel.dialogState = false
            }
        ) {
            DialogContent(
                onCameraClick = {
                    activity.launcher.launch(activity.documentScanner.createDocumentScanIntent())
                    viewModel.dialogState = false
                },
                onGalleryClick = {

                    requestImage.launch(
                        PickVisualMediaRequest(
                            ActivityResultContracts.PickVisualMedia.ImageOnly
                        )
                    )
                    viewModel.dialogState = false
                },
                requestImage = requestImage
            )
        }
    }

    LaunchedEffect(imageUri){
        if(imageUri != null){
            Log.d(TAG,"imageUri - $imageUri")

            mainViewModel.bitmap = imageUri!!.uriToBitmap(context)

            if( mainViewModel.bitmap != null ){
                multipartBody = mainViewModel.bitmap!!.bitmapToMultipart("flie")



                Log.d(TAG,"multipartBody Changed")
                Log.d(TAG," MultiBody Type : ${multipartBody!!.body.contentType()}")

                if(multipartBody != null){

                    viewModel.postClovaOcr(
                        multipartBody!!,
                        MessageModel(
                            timestamp = 1698993348536,
                            images = listOf(ImageModel(
                                format = "jpeg",
                                name = "card"
                            ))
                        )
                    )
                }
                else {
                    viewModel.ClovaOcrReault = null
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
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
        ){
            CreateView(
                activity,
                requestImageFromExternalStorage,
                requestImage,
                bitmap,
                viewModel
            )

            Spacer(
                modifier = Modifier
                    .height(100.dp)
            )

            CreateButton(
                {
                    isButtonEnabled = false

                    if(multipartBody != null){
                        viewModel.postCard(multipartBody!!)

                    }
                    else {
                        Log.d(TAG, "CreateScreen: image is null")
                        isButtonEnabled = true

                    }

                },
                isButtonEnabled
            )
        }
    }

}

//@Preview
//@Composable
//fun PreviewCreateScreen(){
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.White),
//        verticalArrangement = Arrangement.SpaceBetween
//    ) {
//
//        DeepTopBar({}, {})
//
//        CreateView(
//            activity = LocalContext.current as? ComponentActivity,
////            rememberImagePicker(onImage = {}),
//            rememberLauncherForActivityResult(ActivityResultContracts.GetContent()){},
//            rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()){},
//            null,
//
//
//            {}
//        )
//
//        CreateButton({},false)
//    }
//}

@Composable
fun CreateView(
    activity: ComponentActivity?,
    requestImageFromExternalStorage : ManagedActivityResultLauncher<String,Uri?>,
    requestImage : ManagedActivityResultLauncher<PickVisualMediaRequest,Uri?>,
    bitmap : Bitmap?,
    viewModel: CreateViewModel
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

//        Column(
//            modifier = Modifier.background(color = Color.Gray, shape = RoundedCornerShape(16.dp))
//        ){
//
//            Spacer(modifier = Modifier.height(50.dp))
//
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .wrapContentHeight(),
//                horizontalArrangement = Arrangement.Center,
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.ic_camera),
//                    contentDescription = "",
//                    modifier = Modifier.clickable {
//                        onCameraClick()
//                    }
//                )
//                Spacer(
//                    modifier = Modifier.width(30.dp)
//                )
//                Image(
//                    painter = painterResource(id = R.drawable.ic_divider),
//                    contentDescription = ""
//                )
//                Spacer(
//                    modifier = Modifier.width(30.dp)
//                )
//                Image(
//                    painter = painterResource(id = R.drawable.ic_gallery),
//                    contentDescription = "",
//                    modifier = Modifier.clickable {
//
//                        when (activity!!.checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)) {
//                            PackageManager.PERMISSION_GRANTED -> {
//
//                                requestImageFromExternalStorage.launch("image/*")
//                            }
//
//                            else -> ActivityCompat.requestPermissions(
//                                activity,
//                                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
//                                1
//                            )
//                        }
//
//                        requestImage.launch(
//                            PickVisualMediaRequest(
//                                ActivityResultContracts.PickVisualMedia.ImageOnly
//                            )
//                        )
//
//                    }
//                )
//            }
//
//            Spacer(modifier = Modifier.height(50.dp))
//        }

        Image(
            modifier = Modifier
                .shadow(Color(0x16000000), 0.dp, 5.dp, 15.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .clickable {
//                    when (activity!!.checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)) {
//                        PackageManager.PERMISSION_GRANTED -> {
//
//                            requestImageFromExternalStorage.launch("image/*")
//                        }
//
//                        else -> ActivityCompat.requestPermissions(
//                            activity,
//                            arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
//                            1
//                        )
//                    }
//                    requestImage.launch(
//                        PickVisualMediaRequest(
//                            ActivityResultContracts.PickVisualMedia.ImageOnly
//                        )
//                    )
                    viewModel.dialogState = true
                },
            painter =
            if (bitmap == null) painterResource(id = R.drawable.bg_upload_img)
            else BitmapPainter(bitmap.asImageBitmap())
            ,
            contentDescription = "이미지를 넣을 칸입니다",
            contentScale = ContentScale.FillWidth,
        )

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
//            onClick = {
//
//            },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            colors = ButtonDefaults.buttonColors(containerColor = DeepBlue),
            shape = RoundedCornerShape(16.dp),
            contentPadding = PaddingValues(vertical = 12.dp),
//            enabled = isBitmapRatioOk
            enabled = true
        ) {
            Text(
                text = "명함 만들기",
                color = Color.White,
                fontFamily = deepFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

    }
}

@Composable
@Preview
fun DialogPreview(){
    DialogContent(onCameraClick = {}, requestImage = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),

        onResult = {}
    ), onGalleryClick = {})

}

@Composable
fun DialogContent(
    onCameraClick : () -> Unit,
    onGalleryClick : () -> Unit,
    requestImage : ManagedActivityResultLauncher<PickVisualMediaRequest,Uri?>
){
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.background(color = Color.White, shape = RoundedCornerShape(18.dp))
    ){
        Spacer(modifier = Modifier.height(50.dp))
        Row(
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(
                modifier = Modifier.width(30.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_camera),
                contentDescription = "",
                modifier = Modifier.clickable {
                    onCameraClick()
                }
            )
            Spacer(
                modifier = Modifier.width(30.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_divider),
                contentDescription = ""
            )
            Spacer(
                modifier = Modifier.width(30.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_gallery),
                contentDescription = "",
                modifier = Modifier.clickable {

//                when (activity!!.checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)) {
//                    PackageManager.PERMISSION_GRANTED -> {
//
//                        requestImageFromExternalStorage.launch("image/*")
//                    }
//
//                    else -> ActivityCompat.requestPermissions(
//                        activity,
//                        arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
//                        1
//                    )
//                }

                    onGalleryClick()

                }
            )

            Spacer(
                modifier = Modifier.width(30.dp)
            )
        }

        Spacer(modifier = Modifier.height(50.dp))
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
private fun Bitmap.bitmapToMultipart(name : String): MultipartBody.Part {
    var byteArrayOutputStream = ByteArrayOutputStream()

    val MAX_IMAGE_SIZE = 1425000
    var compressQuality = 100

    var streamLength = MAX_IMAGE_SIZE

    while(streamLength >= MAX_IMAGE_SIZE){

        byteArrayOutputStream = ByteArrayOutputStream()

        Log.d(TAG,"compressQuality - ${compressQuality}")
        this.compress(Bitmap.CompressFormat.JPEG, compressQuality , byteArrayOutputStream)
        streamLength = byteArrayOutputStream.size()
        Log.d(TAG,"streamLength - ${streamLength}")
        compressQuality -= 5

        if(compressQuality <= 0) break

    }

    this.compress(Bitmap.CompressFormat.JPEG, compressQuality , byteArrayOutputStream)

    val requestFile =
        RequestBody.create("image/jpeg".toMediaTypeOrNull(), byteArrayOutputStream.toByteArray())


    return MultipartBody.Part.createFormData(/*"card_image",*/"file", "image.jpeg", requestFile)
}



