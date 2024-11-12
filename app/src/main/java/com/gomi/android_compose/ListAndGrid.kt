package com.gomi.android_compose

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

class ListAndGrid {
    /*
        길이가 긴 리스트 : LazyColumn , LazyRow , LazyVerticalGrid
     */
    object ListAndGridEx {

        @Composable
        fun mainScreen() {
            rowList()
        }

        @Composable
        fun columnList() {
            val scrollState = rememberScrollState() // 스크롤 상태를 저장
            val coroutineScope = rememberCoroutineScope() // anmateScrollTo 를 호출하기 위한 코루틴 스코프 생성

            Column {
                Row{
                    Button(onClick = {
                         coroutineScope.launch {
                         scrollState.animateScrollTo(0) // animateScrollTo는 suspend function 이므로 코루틴 스코프에서 실행.
                     }
                    },
                        modifier = Modifier
                            .weight(0.5f)
                            .padding(2.dp)){
                                Text("Top")
                    }

                    Button(onClick = {
                        coroutineScope.launch {
                            scrollState.animateScrollTo(scrollState.maxValue)
                        }
                    },
                        modifier = Modifier
                            .weight(0.5f)
                            .padding(2.dp)){
                        Text("End")
                    }


                }
                Column(Modifier.verticalScroll(scrollState)) {
                    repeat(500) {
                        Text("List Item $it",
                            style = MaterialTheme.typography.headlineSmall,
                            modifier = Modifier.padding(5.dp),
                        )
                    }
                }
            }
        }

        @Composable
        fun rowList() {
            val scrollState = rememberScrollState()
            Row(Modifier.horizontalScroll(scrollState)) {
                repeat(50) {
                    Text("$it",style=MaterialTheme.typography.headlineLarge,
                        modifier = Modifier.padding(5.dp))
                }
            }
        }

    }
}