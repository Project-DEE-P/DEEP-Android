package com.example.app.presentation.screen.putnfc

import android.annotation.SuppressLint
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.app.MainActivity
import com.example.app.MainViewModel
import com.example.app.presentation.screen.cardlist.DeepTopBar
import com.example.app.ui.theme.Blue
import com.example.app.util.TAG
import com.example.app.util.deepFontFamily
import com.example.app.util.shadow
import com.example.domain.model.card.CardDto
import com.example.domain.model.card.PostCardModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalPagerApi::class, ExperimentalMaterial3Api::class)
@Composable
fun PutNfcScreen(
    navController: NavController,
    mainViewModel: MainViewModel,
    alert: (@Composable () -> Unit) -> Unit,
    viewModel: PutNfcViewModel = hiltViewModel()
){
    val text by rememberUpdatedState(newValue = mainViewModel.text)
    val textColor by rememberUpdatedState(newValue = mainViewModel.textColor)
    val isButtonEnabled by rememberUpdatedState(newValue = mainViewModel.isButtonEnabled)
    val context = LocalContext.current

    var isShowAlert by remember { mutableStateOf(false) }

    val activity = context as? ComponentActivity

    val pagerState = rememberPagerState()

    val cardList by rememberUpdatedState(newValue = viewModel.cardList)

    DisposableEffect(Unit){
        viewModel.getCardList()

        onDispose {}
    }

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



        Column(){
            DeepTopBar({}, {})

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
        }



        CreateView(
            cardList,
            pagerState
        )

        CreateButton(
            {
                Log.d(TAG, "CreateScreen: intent : ${mainViewModel.intent} ")

                if(mainViewModel.intent != null){
                    val ndefMessage =
                        (activity as MainActivity).createNdefMessage("https://de2p.vercel.app/showcard/5")
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
    cardList : List<CardDto>?,
    pagerState: PagerState
){

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {

        if(cardList != null){
            if (!cardList.isEmpty()) {

                HorizontalPager(
                    count = cardList.size,
                    state = pagerState,
                    modifier = Modifier
                        .wrapContentHeight()
                        .fillMaxWidth()
                ) {
                    CardItem(cardList[it])
                }
            } else {
                Text(
                    text = "제작된 명함이 없습니다",
                    color = Color.Black,
                    fontSize = 25.sp,
                    fontFamily = deepFontFamily,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 18.dp)
                )

            }
        }

    }
}


@Composable
fun CardItem(
    data : CardDto
){
    Column(
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight()
            .background(color = Color.White)
            .padding(horizontal = 18.dp),
        horizontalAlignment = Alignment.Start
    ) {

        Text(
            text = /*if (data.createdDateTime.length > 10) data.createdDateTime.substring(0, 10) else */"시간 오류",
            color = Color.Gray,
            fontSize = 14.sp,
            fontFamily = deepFontFamily,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(start = 5.dp)
        )

        Spacer(modifier = Modifier.height(5.dp))

        AsyncImage(
            modifier = Modifier
                .shadow(Color(0x16000000), 0.dp, 5.dp, 15.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp)),
            model = /*data.imagePath*/"https://file.newswire.co.kr/data/datafile2/thumb_480/2010/03/2089341128_20100308105030_1283149681.jpg",
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




