package com.gomi.android_compose

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.unit.dp

class ConstraintLayout {
    /*
        Compse의 ConstraintLayout

        opposing constraint : 동일한 축을 따라 한 컴포저블이 가진 2개의 제약. 반대 제약이 구현되면 컴포저블의 위치는 좌표가 아닌 비율로 정의됨.
        Chain : 하나의 그룹으로 정의된 2개 이상의 컴포저블을 포함하는 레이아웃.
        Guideline : 수평 / 수직 방향으로 설정. 축에 맞춰 정렬할 때 유용하다.
        Barrier : 가상의 뷰로 컴포저블들을 레이아웃 안에 표시되도록 제한 할 때 사용. 수직 , 수평으로 배치 될 수 있고 하나 이상의 컴포저블을 이에 맞춰 제약한다.

     */
    object ConstraintLayoutEx {
        @Composable
        fun mainScreen() {
            /*
            ConstraintLayout(Modifier.size(width = 350.dp, height = 220.dp)) {
                val (button1, button2, button3) = createRefs()

                val barrier = createEndBarrier(button1, button2)

                myButton(
                    text = "Button1",
                    Modifier
                        .width(100.dp)
                        .constrainAs(button1) {
                            top.linkTo(parent.top, margin = 30.dp)
                            start.linkTo(parent.start, margin = 8.dp)
                        }
                )

                myButton(
                    text = "Button2",
                    Modifier
                        .width(150.dp)
                        .constrainAs(button2) {
                            top.linkTo(button1.bottom, margin = 20.dp)
                            start.linkTo(parent.start, margin = 8.dp)
                        }
                )

                myButton(
                    text = "Button3",
                    Modifier.constrainAs(button3) {
                        linkTo(
                            parent.top,
                            parent.bottom,
                            topMargin = 8.dp,
                            bottomMargin = 8.dp
                        )
                        start.linkTo(barrier, margin = 30.dp)
                        end.linkTo(parent.end, margin = 8.dp)
                        width = Dimension.fillToConstraints
                        height = Dimension.fillToConstraints
                    }
                )
            }*/
        }

        @Composable
        fun myButton(text: String , modifier: Modifier = Modifier) {
            Button(
                onClick = {} ,
                modifier = modifier
            ) {
                Text(text)
            }
        }
    }
}