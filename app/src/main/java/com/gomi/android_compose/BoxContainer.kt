package com.gomi.android_compose

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class BoxContainer {
    /*
        Box
        자식 요소들을 스택을 배치한다.
     */
    object BoxContainerEx {

        @Preview
        @Composable
        fun mainScreen() {
            /*
            Box(contentAlignment = Alignment.CenterEnd ,
                modifier = Modifier.size(400.dp,400.dp).background(Color.Yellow)){
                val heigit = 200.dp
                val width = 200.dp

                TextCell(text = "1", Modifier.size(width = width, height = heigit))
                TextCell(text = "2", Modifier.size(width = width, height = heigit))
                TextCell(text = "3", Modifier.size(width = width, height = heigit))
            }*/

            /* Box 안에서 자식요소들 배치
            Box(modifier = Modifier.size(height = 90.dp,width=290.dp)) {
                Text("1",Modifier.align(Alignment.TopStart))
                Text("2",Modifier.align(Alignment.TopCenter))
                Text("3",Modifier.align(Alignment.TopEnd))
                Text("4",Modifier.align(Alignment.CenterStart))
                Text("5",Modifier.align(Alignment.Center))
                Text("6",Modifier.align(Alignment.CenterEnd))
                Text("7",Modifier.align(Alignment.BottomStart))
                Text("8",Modifier.align(Alignment.BottomCenter))
                Text("9",Modifier.align(Alignment.BottomEnd))
            }*/

            Box(Modifier.size(200.dp).
            clip(CircleShape)
                .background(Color.Blue))
        }
        @Composable
        fun TextCell(text: String , modifier: Modifier = Modifier , fontSize: Int = 150) {
            val cellModifier = Modifier
                .padding(4.dp)
                .border(width = 5.dp, color = Color.Black)
            Surface {   //TextCell의 배경을 불투명 하게 하기 위해 Surface 안에서 Text를 호출
                Text(text = text, cellModifier.then(modifier),
                    fontSize = fontSize.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center)
            }
        }
    }
}