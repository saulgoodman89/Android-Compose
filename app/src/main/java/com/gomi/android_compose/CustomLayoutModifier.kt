package com.gomi.android_compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

class CustomLayoutModifier {
    /*
        Custom Layout Modifier 를 이용해 Custom Layout을 개발
     */
    object CLM {
        @Composable
        fun mainScreen() {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.size(120.dp, 80.dp)) {
                Column {
                    colorBox(Modifier.exampleLayout(0f).background(Color.Blue))
                    colorBox(Modifier.exampleLayout(0.25f).background(Color.Green))
                    colorBox(Modifier.exampleLayout(0.5f).background(Color.Yellow))
                    colorBox(Modifier.exampleLayout(0.25f).background(Color.Red))
                    colorBox(Modifier.exampleLayout(0.0f).background(Color.Magenta))
                }
            }
        }

        @Composable
        fun colorBox(modifier: Modifier) {
            Box(
                Modifier
                    .padding(1.dp)
                    .size(width = 50.dp, height = 10.dp)
                    .then(modifier)
            )
        }

        /*
        fun Modifier.exampleLayout(
            x:Int , y: Int
        ) = layout { measurable, constraints ->
            val placeable = measurable.measure(constraints)

                //   val x = -(placeable.width * fraction).roundToInt()

            layout(placeable.width, placeable.height) {
                placeable.placeRelative(x = x, y = 0)
            }
        }*/

        fun Modifier.exampleLayout(
            fraction: Float
        ) = layout { measurable, constraints ->
            val placeable = measurable.measure(constraints)

            val x = -(placeable.width * fraction).roundToInt()

            layout(placeable.width, placeable.height) {
                placeable.placeRelative(x = x, y = 0)
            }
        }
    }
}