package com.gomi.android_compose

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

class CompositionLocalEx {
    object CompositionLocal {
        val localColor = staticCompositionLocalOf { Color(0xFFffdbcf) }
        @Composable
        fun composable1() {
            var color = if (isSystemInDarkTheme()) {
                Color(0xFFa08d87)
            } else {
                Color(0xFFffdbcf)
            }
            Column {
                composable2()
                /*
                   provides 키워드를 사용해 localColor에 color 값을 제공.
                    composable3 에서는 localColor를 통해 color 값을 사용 할 수 있다.
                 */
                CompositionLocalProvider(localColor provides color) {
                    composable3()
                }
            }
        }

        @Composable
        fun composable2() {
            composable4()
        }

        @Composable
        fun composable3() {
            /*
                CompositionLocalProvider를 통해 composable1() 함수에서 전달된 color 값에 접근 할 수 있다.


             */
            Text("Composable 3", modifier = Modifier.background(localColor.current))
            CompositionLocalProvider(localColor provides Color.Red) {
                composable5()
            }
        }

        @Composable
        fun composable4() {
            composable6()
        }

        @Composable
        fun composable5() {
           Text("Composable 5", modifier = Modifier.background(localColor.current))
            CompositionLocalProvider(localColor provides Color.Green) {
                composable7()
            }

            CompositionLocalProvider(localColor provides Color.Yellow) {
                composable8()
            }
        }

        @Composable
        fun composable6() {
            Text("Composable 6", modifier = Modifier.background(localColor.current))
        }

        @Composable
        fun composable7() {
            Text("Composable 7", modifier = Modifier.background(localColor.current))
        }

        @Composable
        fun composable8() {
            Text("Composable 8", modifier = Modifier.background(localColor.current))
        }

    }
}