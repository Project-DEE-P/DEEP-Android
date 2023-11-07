package com.example.app.presentation.screen.carddetail

import android.content.Context
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.app.MainViewModel
import com.example.app.presentation.screen.cardlist.DeepTopBar
import com.example.app.presentation.screen.create.CreateButton
import com.example.app.presentation.screen.create.CreateView
import com.example.app.presentation.screen.create.CreateViewModel
import com.example.app.presentation.screen.create.OcrItem
import com.example.app.presentation.screen.create.OcrResult
import com.example.app.presentation.screen.putnfc.OcrResultData
import com.example.app.presentation.screen.putnfc.OcrType
import com.example.app.util.TAG
import com.example.app.util.deepFontFamily
import com.example.app.util.shadow
import com.example.deep_android.R
import com.example.domain.model.ClovaOcrDto
import com.example.domain.model.card.CardDto
import com.example.domain.model.card.PostCardModel
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun CardDetailScreen(
    mainViewModel: MainViewModel
){

    val selectedCard by rememberUpdatedState(newValue = mainViewModel.selectedCard)
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Top
    ) {

        DeepTopBar({}, {})

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ){

            Spacer(modifier = Modifier.height(10.dp))

            AsyncImage(
                modifier = Modifier
                    .shadow(Color(0x16000000), 0.dp, 5.dp, 15.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp)),
                model = "https://file.newswire.co.kr/data/datafile2/thumb_480/2010/03/2089341128_20100308105030_1283149681.jpg",
                contentDescription = "명함 이미지입니다",
                contentScale = ContentScale.FillWidth
            )

            Spacer(modifier = Modifier.height(10.dp))
            
            OcrResult(
                modifier = Modifier,
                cardDto = selectedCard,
                context = context,
            )




        }
    }

}

@Composable
fun OcrResult(
    cardDto : CardDto?,
    modifier : Modifier,
    context : Context
){

    if (cardDto != null){

        Column{
            var text = ""

            if (!cardDto.name.isEmpty()) {
                text = cardDto.name.replace(',', '/')
            }

            val ocrText: MutableList<OcrResultData> = mutableListOf<OcrResultData>().apply {

                if(!cardDto.company.isEmpty()){
                    cardDto.company.split(",").forEach {
                        add(OcrResultData(OcrType.회사, it, false, false, false))
                    }
                }

                if(!cardDto.department.isEmpty()){
                    cardDto.department.split(",").forEach {
                        add(OcrResultData(OcrType.부서, it, false, false, false))
                    }
                }

                if(!cardDto.position.isEmpty()){
                    cardDto.position.split(",").forEach {
                        add(OcrResultData(OcrType.직책, it, false, false, false))
                    }
                }

                if(!cardDto.mobile.isEmpty()){
                    cardDto.mobile.split(",").forEach {
                        add(OcrResultData(OcrType.모바일, it, true, false, false))
                    }
                }

                if(!cardDto.tel.isEmpty()){
                    cardDto.tel.split(",").forEach {
                        add(OcrResultData(OcrType.전화, it, true, false, false))
                    }
                }

                if(!cardDto.email.isEmpty()){
                    cardDto.email.split(",").forEach {
                        add(OcrResultData(OcrType.이메일, it, false, false, true))
                    }
                }

                if(!cardDto.homepage.isEmpty()){
                    cardDto.homepage.split(",").forEach {
                        add(OcrResultData(OcrType.홈페이지, it, false, false, true))
                    }
                }

                if(!cardDto.fax.isEmpty()){
                    cardDto.fax.split(",").forEach {
                        add(OcrResultData(OcrType.팩스, it, false, true, false))
                    }
                }

                if(!cardDto.address.isEmpty()){
                    cardDto.address.split(",").forEach {
                        add(OcrResultData(OcrType.주소, it, false, true, false))
                    }
                }

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

                    OcrItem(text, data = item, context)
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
    }

}
