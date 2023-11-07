package com.example.app.presentation.screen.cardlist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.app.util.deepFontFamily
import com.example.app.util.shadow
import com.example.deep_android.R
import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.app.MainViewModel
import com.example.app.presentation.navigation.Screen
import com.example.app.ui.theme.Blue
import com.example.domain.model.card.CardDto
import com.example.domain.model.card.PostCardModel

@Composable
fun CardListScreen(
    navController: NavController,
    viewModel : CardListViewModel = hiltViewModel(),
    mainViewModel: MainViewModel
){

    val rememberedCardList by rememberUpdatedState(newValue = viewModel.rememberedCardList)

    DisposableEffect(Unit){
        viewModel.getRememberedCardList()

        onDispose {  }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White
            )
    ) {
        DeepTopBar({}, {})
        Spacer(modifier = Modifier.height(10.dp))
        TitleCardList("최희건")
        Spacer(
            modifier = Modifier.height(30.dp)
        )
        CardList(
            rememberedCardList,
            navController,
            mainViewModel
        )
    }
}

@Composable
@Preview
fun PreviewCardListScreen(){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White
            )
    ) {
        DeepTopBar({}, {})
        Spacer(modifier = Modifier.height(10.dp))
        TitleCardList("최희건")
        Spacer(
            modifier = Modifier.height(30.dp)
        )
        CardList(
            null,
            rememberNavController(),
            hiltViewModel()
        )
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
fun TitleCardList(userName : String){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 18.dp)
    ) {

        val annoatedTitleString = buildAnnotatedString {
            append("${userName} 님의 ")

            withStyle(style = SpanStyle(color = Blue.DeepBlue)) {
                append("DEE:P")
            }

            append(" 명함 리스트")
        }

        Text(
            text = annoatedTitleString,
            color = Color.Black,
            fontFamily = deepFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
    }
}

@Composable
fun CardList(
    cardList : List<CardDto>?,
    navController: NavController,
    mainViewModel: MainViewModel
){
    if(cardList != null){
        if (!cardList.isEmpty()) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                verticalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                itemsIndexed(
                    cardList
                ) { index: Int, item: CardDto ->
                    CardListItem(
                        data = item,
                        navController = navController,
                        mainViewModel
                    )
                }
            }
        } else {
            Text(
                text = "저장된 명함이 없습니다",
                color = Color.Black,
                fontSize = 25.sp,
                fontFamily = deepFontFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 18.dp)
            )
        }
    }
}

@Composable
fun CardListItem(
    data : CardDto,
    navController: NavController,
    mainViewModel: MainViewModel
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 18.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = "${"as"/*data.uid*/} 님의 명함",
                    modifier = Modifier.padding(start = 5.dp),
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontFamily = deepFontFamily,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = /*data.createdDateTime*/"as",
                    color = Color.Gray,
                    fontSize = 12.sp,
                    fontFamily = deepFontFamily,
                    fontWeight = FontWeight.Normal
                )
            }
            Image(
                modifier = Modifier
                    .height(20.dp)
                    .padding(end = 5.dp),
                painter = painterResource(id = R.drawable.ic_three_dot),
                contentDescription = "더보기 버튼입니다"
            )
        }

        Spacer(modifier = Modifier.height(5.dp))

        AsyncImage(
            modifier = Modifier
                .shadow(Color(0x16000000), 0.dp, 5.dp, 15.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .clickable {
                    mainViewModel.selectedCard = data
                    navController.navigate(Screen.CardDetail.route)
                },
            model = /*data.imagePath*/"https://file.newswire.co.kr/data/datafile2/thumb_480/2010/03/2089341128_20100308105030_1283149681.jpg",
            contentDescription = "명함 이미지입니다",
            contentScale = ContentScale.FillWidth
        )

    }
}