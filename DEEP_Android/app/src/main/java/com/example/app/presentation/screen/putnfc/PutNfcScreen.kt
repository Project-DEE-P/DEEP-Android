package com.example.app.presentation.screen.putnfc

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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.core.app.ActivityCompat
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.app.MainActivity
import com.example.app.MainViewModel
import com.example.app.presentation.screen.cardlist.CardData
import com.example.app.presentation.screen.cardlist.DeepTopBar
import com.example.app.ui.theme.Blue
import com.example.app.util.TAG
import com.example.app.util.deepFontFamily
import com.example.app.util.shadow
import com.example.data.network.repository.CardRepositoryImpl
import com.example.deep_android.R
import com.example.domain.repository.CardRepository
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun PutNfcScreen(navController: NavController, mainViewModel: MainViewModel, alert: (@Composable () -> Unit) -> Unit){
    val text by rememberUpdatedState(newValue = mainViewModel.text)
    val textColor by rememberUpdatedState(newValue = mainViewModel.textColor)
    val isButtonEnabled by rememberUpdatedState(newValue = mainViewModel.isButtonEnabled)
    val context = LocalContext.current

    var isShowAlert by remember { mutableStateOf(false) }

    val activity = context as? ComponentActivity

    val pagerState = rememberPagerState()

    val cardList = listOf(CardData("PARAOOO","2023년 6월 13일"),CardData("SeokgyuYun","2023년 6월 13일"),CardData("yr0118kim","2023년 6월 13일"),CardData("snack655","2023년 6월 13일"),CardData("최희건","2023년 6월 13일"))

//    mainViewModel.getList()

    LaunchedEffect(Unit) {
        mainViewModel.successEvent.collect {
            if (it) {
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
//        if(isSuccessed != null){
//            if (isSuccessed!!) {
//                isShowAlert = true
//                alert {
//                    ConnectDialog(
//                        text = "명함 등록에 성공했습니다",
//                        onClick = { isShowAlert = false },
//                        isShow = isShowAlert
//                    )
//                }
//
//            } else {
//                isShowAlert = true
//                alert {
//                    ConnectDialog(
//                        text = "명함 등록에 실패했습니다",
//                        onClick = { isShowAlert = false },
//                        isShow = isShowAlert
//                    )
//                }
//            }
//        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        DeepTopBar({}, {})

        CreateView(
            cardList,
            pagerState
        )

        CreateButton(
            {
                Log.d(TAG, "CreateScreen: intent : ${mainViewModel.intent} ")

                if(mainViewModel.intent != null){
                    val ndefMessage =
                        (activity as MainActivity).createNdefMessage("https://www.github.com/${cardList[pagerState.currentPage].name}")
                    (activity as MainActivity).writeNdefMessageToTag(mainViewModel.intent!!, ndefMessage)
                }
            },
            text,
            textColor,
            isButtonEnabled
        )
    }

}

@Preview
@Composable
fun PreviewCreateScreen(){


}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun CreateView(
    cardList : List<CardData>?,
    pagerState: PagerState
){

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Text(
            text = "NFC 태그에 명함 넣기",
            color = Color.Black,
            fontFamily = deepFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(horizontal = 18.dp)
        )

        Spacer(modifier = Modifier.height(14.dp))

        if(cardList != null){

            HorizontalPager(
                count = cardList.size,
                state = pagerState,
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
            ) {
                CardItem(cardList[it])
            }
        }
        else {
            Text(text = "하하 명함이 없네요")
        }

    }
}


@Composable
fun CardItem(
    data : CardData
){
    Column(
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight()
            .background(color = Color.White),
        horizontalAlignment = Alignment.Start
    ) {

        Text(
            text = data.date,
            color = Color.Gray,
            fontSize = 14.sp,
            fontFamily = deepFontFamily,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(start = 5.dp)
        )

        Spacer(modifier = Modifier.height(5.dp))

        Image(
            modifier = Modifier
                .shadow(Color(0x16000000), 0.dp, 5.dp, 15.dp)
                .width(340.dp)
                .clip(RoundedCornerShape(16.dp)),
            painter = painterResource(id = R.drawable.img_card_dummy),
            contentDescription = "명함 이미지입니다",
            contentScale = ContentScale.FillWidth
        )
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
            colors = ButtonDefaults.buttonColors(containerColor = Blue.DeepBlue),
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

        Spacer(modifier = Modifier.height(12.dp))

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
                    colors = ButtonDefaults.buttonColors(containerColor = Blue.DeepBlue),
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




