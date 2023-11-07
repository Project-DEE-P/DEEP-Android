package com.example.app.presentation.screen.create

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.ContactsContract
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.window.Dialog
import androidx.core.content.ContextCompat.startActivity
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.app.presentation.screen.cardlist.DeepTopBar
import com.example.app.presentation.screen.putnfc.OcrResultData
import com.example.app.presentation.screen.putnfc.OcrType
import com.example.app.ui.theme.Blue
import com.example.app.ui.theme.Blue.DeepBlue
import com.example.app.ui.theme.Gray
import com.example.domain.model.card.PostCardModel
import com.example.domain.model.ClovaOcrDto
import com.example.domain.model.ImageDto
import com.example.domain.model.ImageModel
import com.example.domain.model.MessageModel
import com.example.domain.model.MetaDto
import com.example.domain.model.NameCardDto
import com.example.domain.model.NameDto
import com.example.domain.model.ResultDto
import com.example.domain.model.ValidationResultDto
import com.example.domain.repository.CardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.ByteArrayOutputStream

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

    val clovaOcrResult by rememberUpdatedState(newValue = viewModel.clovaOcrResult)

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

//    LaunchedEffect(viewModel.clovaOcrResult){
//        Log.d(TAG, "ClovaOcrResult - ${viewModel.clovaOcrResult}")
//    }

    val activity = context as MainActivity
//
//    val scrollState = rememberScrollState()

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
//                    activity.launcher.launch(activity.documentScanner.createDocumentScanIntent())
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
        }
    }

    LaunchedEffect(bitmap){

        viewModel.clovaOcrResult = null

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
                viewModel.clovaOcrResult = null
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
                .fillMaxWidth()
                .padding(horizontal = 18.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ){
            CreateView(
                activity,
                requestImage,
                bitmap,
                viewModel
            )

            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Bottom
            ){
                OcrResult(
                    clovaOcrResult,
                    Modifier.weight(1f),
                    context,
                    viewModel
                )

                Spacer(modifier = Modifier.height(10.dp))

                CreateButton(
                    {
                        isButtonEnabled = false

                        if (multipartBody != null && viewModel.requestData != null) {
                            viewModel.postCard(multipartBody!!,viewModel.requestData!!)
                        } else {
                            Log.d(TAG, "CreateScreen: image is null")
                            isButtonEnabled = true
                        }
                    },
                    isButtonEnabled
                )
            }
        }
    }

}



@Composable
fun OcrResult(
    data : ClovaOcrDto?,
    modifier : Modifier,
    context : Context,
    viewModel : CreateViewModel
){

    if (data != null){
        var ocrText: MutableList<OcrResultData> = mutableListOf()

        viewModel.requestData = PostCardModel(
            "","","","","","","","","",""
        ).apply {

            if(data.images[0].nameCard.result.name != null){
                name = data.images[0].nameCard.result.name!!.get(0).text

                data.images[0].nameCard.result.name!!.subList(1,data.images[0].nameCard.result.name!!.size).forEach {
                    name = name + ",${it.text}"
                }
            }

            if(data.images[0].nameCard.result.company != null){
                company = data.images[0].nameCard.result.company!!.get(0).text

                data.images[0].nameCard.result.company!!.subList(1,data.images[0].nameCard.result.company!!.size).forEach {
                    company = company + ",${it.text}"
                }
            }

            if(data.images[0].nameCard.result.department != null){
                department = data.images[0].nameCard.result.department!!.get(0).text

                data.images[0].nameCard.result.department!!.subList(1,data.images[0].nameCard.result.department!!.size).forEach {
                    department = department + ",${it.text}"
                }
            }

            if(data.images[0].nameCard.result.position != null){
                position = data.images[0].nameCard.result.position!!.get(0).text

                data.images[0].nameCard.result.position!!.subList(1,data.images[0].nameCard.result.position!!.size).forEach {
                    position = position + ",${it.text}"
                }
            }

            if(data.images[0].nameCard.result.tel != null){
                tel = data.images[0].nameCard.result.tel!!.get(0).text

                data.images[0].nameCard.result.tel!!.subList(1,data.images[0].nameCard.result.tel!!.size).forEach {
                    tel = tel + ",${it.text}"
                }
            }

            if(data.images[0].nameCard.result.address != null){
                address = data.images[0].nameCard.result.address!!.get(0).text

                data.images[0].nameCard.result.address!!.subList(1,data.images[0].nameCard.result.address!!.size).forEach {
                    address = address + ",${it.text}"
                }
            }

            if(data.images[0].nameCard.result.mobile != null){
                mobile = data.images[0].nameCard.result.mobile!!.get(0).text

                data.images[0].nameCard.result.mobile!!.subList(1,data.images[0].nameCard.result.mobile!!.size).forEach {
                    mobile = mobile + ",${it.text}"
                }
            }

            if(data.images[0].nameCard.result.email != null){
                email = data.images[0].nameCard.result.email!!.get(0).text

                data.images[0].nameCard.result.email!!.subList(1,data.images[0].nameCard.result.email!!.size).forEach {
                    email = email + ",${it.text}"
                }
            }

            if(data.images[0].nameCard.result.fax != null){
                fax = data.images[0].nameCard.result.fax!!.get(0).text

                data.images[0].nameCard.result.fax!!.subList(1,data.images[0].nameCard.result.fax!!.size).forEach {
                    fax = fax + ",${it.text}"
                }
            }

            if(data.images[0].nameCard.result.homepage != null){
                homepage = data.images[0].nameCard.result.homepage!!.get(0).text

                data.images[0].nameCard.result.homepage!!.subList(1,data.images[0].nameCard.result.homepage!!.size).forEach {
                    homepage = homepage + ",${it.text}"
                }
            }

        }

        Log.d(TAG,"requestData - ${viewModel.requestData}")

        var text = ""

        if(data.images[0].nameCard.result.name != null){
            text = data.images[0].nameCard.result.name!!.get(0).text

            data.images[0].nameCard.result.name!!.subList(1,data.images[0].nameCard.result.name!!.size).forEach {
                text = text + " / ${it.text}"
            }
        }


        data.images[0].nameCard.result.company?.forEach {
            ocrText.add(
                OcrResultData(
                    type = OcrType.회사,
                    value = it.text,
                    isAddress = false,
                    isCopy = false,
                    isLink = false
                )
            )
        }
        data.images[0].nameCard.result.position?.forEach {
            ocrText.add(
                OcrResultData(
                    type = OcrType.직책,
                    value = it.text,
                    isAddress = false,
                    isCopy = false,
                    isLink = false
                )
            )
        }
        data.images[0].nameCard.result.department?.forEach {
            ocrText.add(
                OcrResultData(
                    type = OcrType.부서,
                    value = it.text,
                    isAddress = false,
                    isCopy = false,
                    isLink = false
                )
            )
        }
        data.images[0].nameCard.result.tel?.forEach {
            ocrText.add(
                OcrResultData(
                    type = OcrType.전화,
                    value = it.text,
                    isAddress = true,
                    isCopy = false,
                    isLink = false
                )
            )
        }
        data.images[0].nameCard.result.mobile?.forEach {
            ocrText.add(
                OcrResultData(
                    type = OcrType.모바일,
                    value = it.text,
                    isAddress = true,
                    isCopy = false,
                    isLink = false
                )
            )
        }
        data.images[0].nameCard.result.email?.forEach {
            ocrText.add(
                OcrResultData(
                    type = OcrType.이메일,
                    value = it.text,
                    isAddress = false,
                    isCopy = true,
                    isLink = false
                )
            )
        }
        data.images[0].nameCard.result.homepage?.forEach {
            ocrText.add(
                OcrResultData(
                    type = OcrType.홈페이지,
                    value = it.text,
                    isAddress = false,
                    isCopy = false,
                    isLink = true
                )
            )
        }
        data.images[0].nameCard.result.fax?.forEach {
            ocrText.add(
                OcrResultData(
                    type = OcrType.팩스,
                    value = it.text,
                    isAddress = false,
                    isCopy = true,
                    isLink = false
                )
            )
        }
        data.images[0].nameCard.result.address?.forEach {
            ocrText.add(
                OcrResultData(
                    type = OcrType.주소,
                    value = it.text,
                    isAddress = false,
                    isCopy = true,
                    isLink = false
                )
            )
        }
        
        Text(
            text = text,
            color = Color.Black,
            fontFamily = deepFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.padding(horizontal = 18.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn(
            modifier = modifier.padding(horizontal = 18.dp)
        ) {
            itemsIndexed(
                ocrText
            ) { index: Int, item: OcrResultData ->

                OcrItem(text,data = item,context)
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }

}
@Composable
fun OcrItem(
    name : String,
    data: OcrResultData,
    context : Context
){

    Row(
        modifier = Modifier
            .shadow(Color(0x16000000), 0.dp, 5.dp, 5.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .background(color = Gray.Gray50, shape = RoundedCornerShape(12.dp)),
        verticalAlignment = Alignment.CenterVertically
    ){

        Spacer(modifier = Modifier.width(7.dp))

        Image(
            modifier = Modifier
                .height(70.dp)
                .width(70.dp)
                .padding(12.dp),
            painter = painterResource(getKeyDrawble(data.type)),
            contentDescription = "",
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.width(7.dp))

        Column(
            verticalArrangement = Arrangement.Bottom
        ) {
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth()
            ){
                Text(
                    text = data.type.name,
                    color = Color.Black,
                    fontFamily = deepFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ){
                    Row(
                        modifier = Modifier.clickable {
                            if(data.isCopy){

                                val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

                                val clip = ClipData.newPlainText("simple text",data.value)

                                clipboard.setPrimaryClip(clip)


                            }
                            if(data.isLink){

                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(data.value))

                                startActivity(context,intent,null)

                            }
                            if(data.isAddress){

                                val intent = Intent(ContactsContract.Intents.Insert.ACTION).apply {
                                    type = ContactsContract.RawContacts.CONTENT_TYPE
                                }

                                intent.apply {
                                    putExtra(ContactsContract.Intents.Insert.PHONE,data.value)

                                    putExtra(ContactsContract.Intents.Insert.NAME,name)
                                }

                                try{ startActivity(context, intent, null) }
                                catch (e : Exception){
                                    Toast.makeText(context,"URL이 잘못되었습니다",Toast.LENGTH_SHORT).show()
                                }

                            }
                        },
                        verticalAlignment = Alignment.CenterVertically

                    ){
                        if(data.isCopy){

                            Text(
                                text = "복사하기",
                                color = Blue.DeepBlue,
                                fontFamily = deepFontFamily,
                                fontWeight = FontWeight.Medium,
                                fontSize = 10.sp
                            )
                        }

                        if(data.isAddress){

                            Text(
                                text = "연락처에 저장하기",
                                color = Blue.DeepBlue,
                                fontFamily = deepFontFamily,
                                fontWeight = FontWeight.Medium,
                                fontSize = 10.sp
                            )
                        }

                        if(data.isLink){
                            Text(
                                text = "이동하기",
                                color = Blue.DeepBlue,
                                fontFamily = deepFontFamily,
                                fontWeight = FontWeight.Medium,
                                fontSize = 10.sp
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(15.dp))

                }
            }
            Text(
                text = data.value,
                color = Gray.Gray300,
                fontFamily = deepFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                lineHeight = 15.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }

}

@Preview
@Composable
fun PreviewOcrItem(

){
    OcrItem(
        "",
        OcrResultData(
            type = OcrType.회사,
            value = "대구소프트웨어마이스터고등학교",
            isAddress = false,
            isCopy = false,
            isLink = true
        ),
        LocalContext.current
    )

}

fun getKeyDrawble(type : OcrType) : Int{

    var id = 0

    when(type){
        OcrType.회사 -> id = R.drawable.ic_company
        OcrType.모바일 -> id = R.drawable.ic_mobile
        OcrType.직책 -> id = R.drawable.ic_position
        OcrType.부서 -> id = R.drawable.ic_department
        OcrType.주소 -> id = R.drawable.ic_address
        OcrType.전화 -> id = R.drawable.ic_tel
        OcrType.팩스 -> id = R.drawable.ic_fax
        OcrType.홈페이지 -> id = R.drawable.ic_web
        OcrType.이메일 -> id = R.drawable.ic_email
    }

    return id
}


@Composable
@Preview
fun PreviewOcrResult(){
    OcrResult(

        ClovaOcrDto(
            images = listOf(
                ImageDto(
                    nameCard = NameCardDto(
                        meta = MetaDto(
                            ""
                        ),
                        result = ResultDto(
                            name = listOf(
                                NameDto(
                                    boundingPolys = listOf(),
                                    maskingPolys = listOf(),
                                    text = "최희건"
                                ),
                                NameDto(
                                    boundingPolys = listOf(),
                                    maskingPolys = listOf(),
                                    text = "Choi Heegun"
                                ),
                            ),
                            company = listOf(
                                NameDto(
                                    boundingPolys = listOf(),
                                    maskingPolys = listOf(),
                                    text = "(주)우아한 형제들"
                                )
                            ),
                            address = null,
                            position = null,
                            mobile = null,
                            tel = listOf(
                                NameDto(
                                    boundingPolys = listOf(),
                                    maskingPolys = listOf(),
                                    text = "010-3159-4631"
                                ),
                                NameDto(
                                    boundingPolys = listOf(),
                                    maskingPolys = listOf(),
                                    text = "010-9443-2321"
                                ),
                            ),
                            email = null,
                            fax = null,
                            homepage = null,
                            nameFurigana = null,
                            department = listOf(
                                NameDto(
                                    boundingPolys = listOf(),
                                    maskingPolys = listOf(),
                                    text = "홍보부"
                                )
                            ),
                        )
                    ),
                    inferResult = "",
                    uid = "",
                    name = "",
                    message = "",
                    validationResult = ValidationResultDto("")

                )
            ),
            requestId = "",
            timestamp = 1,
            version = ""
        ),
        Modifier,
        LocalContext.current,
        hiltViewModel()

    )
}

@Composable
fun CreateView(
    activity: ComponentActivity?,
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

        Image(
            modifier = Modifier
                .shadow(Color(0x16000000), 0.dp, 5.dp, 15.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .clickable {

                    viewModel.dialogState = true
                },
            painter =
            if (bitmap == null) painterResource(id = R.drawable.bg_upload_img)
            else BitmapPainter(bitmap.asImageBitmap())
            ,
            contentDescription = "이미지를 넣을 칸입니다",
            contentScale = ContentScale.FillWidth,
        )

        Spacer(modifier = Modifier.height(20.dp))

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



