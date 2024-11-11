package com.gomi.android_compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.dp

class CustomLayout {
    object CustomLayoutEx {
        @Composable
        fun mainScreen() {
            Box {
                CascadeLayout(spacing = 20) {
                    Box(modifier = Modifier.size(60.dp).background(Color.Blue))
                    Box(modifier = Modifier.size(80.dp, 40.dp).background(Color.Red))
                    Box(modifier = Modifier.size(90.dp, 100.dp).background(Color.Cyan))
                    Box(modifier = Modifier.size(50.dp).background(Color.Magenta))
                    Box(modifier = Modifier.size(70.dp).background(Color.Green))
                }
            }
        }
        @Composable
        fun CascadeLayout(
            modifier: Modifier = Modifier,
            spacing: Int = 0,
            content: @Composable () -> Unit
        ) {
            Layout(
                modifier = modifier,
                content = content
            ) { measurables, constraints ->
                var indent = 0

                layout(constraints.maxWidth, constraints.maxHeight) {   // layout 크기를 부모의 최대 크기 설정
                    var yCoord = 0

                    /*
                        자식 요소 측정
                        모든 자식 요소를 부모의 제약조건에 따라 측정
                        mesurable : 측정할 수 있는 자식요소
                        placeable : 측정된 크기를 가지며 배치할 수 있는 자식 요소
                        constraints : 부모로 부터 전달된 최소 / 최대 너비와 높이의 제한.
                     */
                    val placeables = measurables.map { measurable ->
                        measurable.measure(constraints)
                    }

                    /*
                        자식 요소 배치
                        placeRelative : 자식 요소를 레이아웃 내에서 상대적인 위치에 배치 
                     */
                    placeables.forEach { placeable ->
                        placeable.placeRelative(x = indent, y = yCoord)
                        indent += placeable.width + spacing
                        yCoord += placeable.height + spacing
                    }
                }
            }
        }
    }
}