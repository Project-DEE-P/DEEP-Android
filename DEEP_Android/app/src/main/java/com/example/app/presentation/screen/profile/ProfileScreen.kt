package com.example.app.presentation.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.app.presentation.navigation.Screen
import com.example.app.presentation.screen.cardlist.CardData
import com.example.app.presentation.screen.cardlist.CardListItem
import com.example.app.presentation.screen.cardlist.DeepTopBar
import com.example.app.util.deepFontFamily
import com.example.app.util.shadow
import com.example.deep_android.R

@Composable
fun ProfileScreen(
    navController: NavController
){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        DeepTopBar(onLogoClick = {}, onCategoryClick = {})

        Spacer(modifier = Modifier.height(60.dp))

        ProfileTitle("최희건")

        Spacer(modifier = Modifier.height(20.dp))

        Column(){
            ListTitle("최희건", { navController.navigate(Screen.Create.route) })

            Spacer(modifier = Modifier.height(6.dp))

            CardList(
                listOf(
                    CardData("최희건", "2023년 6월 13일"),
                    CardData("최희건", "2023년 6월 13일"),
                    CardData("최희건", "2023년 6월 13일"),
                    CardData("최희건", "2023년 6월 13일"),
                    CardData("최희건", "2023년 6월 13일")
                )
            )
        }
    }
}

@Composable
@Preview
fun PreviewProfileScreen(){
    ProfileScreen(navController = rememberNavController())
}

@Composable
fun ProfileTitle(
    name : String
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 18.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            painter = painterResource(id = R.drawable.ic_profile),
            contentDescription = "프로필 제목 아이콘입니다",
            modifier = Modifier.height(26.dp)
        )
        Spacer(
            modifier = Modifier
                .width(3.dp)
        )
        Text(
            text = name,
            color = Color.Black,
            fontFamily = deepFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 25.sp
        )
    }
}

@Composable
fun ListTitle(
    name : String,
    onCreateClick : () -> Unit
){

    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 18.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "${ name } 님이 제작한 명함 리스트",
            color = Color.Black,
            fontFamily = deepFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp
        )

        Button(
            onClick = onCreateClick,
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_plus),
                contentDescription = "명함 제작 버튼입니다")
        }
    }

}

@Composable
fun CardList(
    list : List<CardData>?
){
    if(list!=null){
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 18.dp),
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            itemsIndexed(
                list!!
            ) { index: Int, item: CardData ->
                CardItem(data = item)
            }
        }
    }
    else{
        Text(
            text = "제작된 명함이 없습니다",
            color = Color.Black,
            fontFamily = deepFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp
        )

    }

}

@Composable
fun CardItem(
    data : CardData
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
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
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp)),
            painter = painterResource(id = R.drawable.img_card_dummy),
            contentDescription = "명함 이미지입니다",
            contentScale = ContentScale.FillWidth
        )
    }
}
