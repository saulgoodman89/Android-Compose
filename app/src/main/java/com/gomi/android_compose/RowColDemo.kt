package com.gomi.android_compose

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class RowColDemo {
    object RowCol {

        @Preview
        @Composable
        fun mainScreen() {

            /*


            Column {
                Row{
                    Column {
                        TextCell(text="1")
                        TextCell(text="2")
                        TextCell(text="3")
                    }

                    Column {
                        TextCell(text="4")
                        TextCell(text="5")
                        TextCell(text="6")
                    }

                    Column {
                        TextCell(text="7")
                        TextCell(text="8")
                        TextCell(text="9")
                    }
                }
            }   */

            /*
                layout 정렬
                1,2,3을 가운데 수평정렬
               Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.size(width = 400.dp, height = 200.dp).background(Color.Yellow)) {
                TextCell(text="1")
                TextCell(text="2")
                TextCell(text="3")
                 }


            Column(horizontalAlignment = Alignment.End, modifier = Modifier.width(width = 250.dp).background(Color.Yellow)) {
                TextCell(text="1")
                TextCell(text="2")
                TextCell(text="3")
            }

            콘텐츠를 Row 끝으로

            Row(horizontalArrangement = Arrangement.End, modifier = Modifier.size(width = 400.dp, height = 200.dp)) {
                TextCell(text="1")
                TextCell(text="2")
                TextCell(text="3")
            }

            자식 콘텐츠들의 간격을 균일하게 유지 : SpaceEvenly
            SpaceBetween : 자식들이 균일한 간격을 유지하지만 첫 번째 자식 앞 , 마지막 자식 뒤 공간 포함X
            SpaceAround : 자식들이 균일한 간격 유지 but 첫번째 , 마지막 자식 뒤 공간은 각 자식사이 공간의 절반

            Row(horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.width(1000.dp)) {
                TextCell(text="1")
                TextCell(text="2")
                TextCell(text="3")
            }
            Row(horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.width(1000.dp)) {
                TextCell(text="1")
                TextCell(text="2")
                TextCell(text="3")
            }

            Row,Column에 Scope Modifier 추가
            Row(modifier = Modifier.height(300.dp)) {
                TextCell(text="1",Modifier.align(Alignment.Top))
                TextCell(text="2",Modifier.align(Alignment.CenterVertically))
                TextCell(text="3",Modifier.align(Alignment.Bottom))
            }
            baseline 으로 정렬
            Row{
                Text(text = "Large Text",
                    Modifier.alignByBaseline(),
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold)
                Text(text = "Small Text",
                    Modifier.alignByBaseline(),
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold)
            }

            weight modifier : 각 자식의 폭을 형제들 기준으로.
            Row{
                TextCell(text="1",Modifier.weight(weight = 0.2f,fill = true))
                TextCell(text="2",Modifier.weight(weight = 0.4f,fill = true))
                TextCell(text="3",Modifier.weight(weight = 0.3f,fill = true))
            }*/
        }

        @Composable
        fun TextCell(text: String,modifier: Modifier = Modifier) {
            val cellModifier = Modifier
                .padding(4.dp)
                .size(100.dp, 100.dp)
                .border(width = 4.dp, color = Color.Black)

            Text(text = text,
                cellModifier.then(modifier),
                fontSize = 70.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center)
        }


    }
}