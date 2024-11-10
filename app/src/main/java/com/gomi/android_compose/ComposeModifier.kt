package com.gomi.android_compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ComposeModifier {
    object ComposeMody {
        @Composable
        fun demoScreen() {
            /*
                modifier 연결 순서는 결과에 큰 영향을 미친다.
                modifier는 
                 val modifier = Modifier.border(width = 2.dp , color = Color.Black)
                .padding(all = 10.dp)

                -> 2dp 두께의 검은색 테두리 그린 후 전체 레이아웃 외부에 10dp 여백 추가
                패딩이 테두리 바깥쪽에 위치.


                val modifier = Modifier.padding(all = 10.dp)
                .border(width = 2.dp , color = Color.Black)
                패딩 안쪽 영역에 테두리 위치

                -> 컨텐츠 내부에 10dp 여백 적용
                피딩이 적용된 콘텐츠 주위에 2dp의 검은 테두리

                Modifier 적용 순서는 안->밖
                첫번째 코드는 테두리를 먼저 적용 , 테두리가 콘텐츠에 직접 붙어있고 그 바깥에 패딩이 추가.
                두번째 코드 : 패딩을 먼저 적용 , 콘텐츠와 테두리 사이에 패딩이 적용하고 테두리가 더 큰영역을 감싼다.
              */
            val modifier = Modifier
                .padding(all = 10.dp)
                .border(width = 2.dp, color = Color.Black)

            Column(
                Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("Hello Compose",
                    modifier = modifier,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold)

                Spacer(modifier = modifier.height(16.dp))
                // Modifier Support
                customImage(image = R.drawable.vacation, modifier = Modifier
                    .padding(16.dp)
                    .width(270.dp)
                    .clip(shape = RoundedCornerShape(30.dp)))
                combinedModifier()
            }

        }

        /*
            Modifier Support
            컴포저블 함수가 Modifier 파라미터를 받아 외부에서 컴폽저블의 속성을 수정할 수 있게한다.
         */
        @Composable
        fun customImage(image: Int , modifier: Modifier){
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                modifier
            )
        }

        /*
            컴포저블에 적용되는 둘 이상의 Modifier를 이용하는 상황이 생기는데 이때 then 을 사용하여 Modifier를 조합한다.
         */
        @Composable
        fun combinedModifier() {
            val modifier = Modifier
                .border(width = 2.dp, color = Color.Red)
                .padding(all = 10.dp)
            val secondModifier = Modifier.height(100.dp).background(Color.Yellow)
            Text(
                "Combined Compose",
                modifier.then(secondModifier),
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}