package com.gomi.android_compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Checkbox
import androidx.compose.ui.unit.dp

class SlotApiEx {
    object SlotApiExample {
        @Composable
        fun mainScreen() {
            var linearSelected by remember { mutableStateOf(true) }
            var imageSelected by remember { mutableStateOf(true) }

            val onLinearClick = {
                value : Boolean -> linearSelected = value
            }

            val onTitleClick = {
                value : Boolean -> imageSelected = value
            }

            screenContent(
                linearSelected = linearSelected,
                imageSelected = imageSelected,
                onTitleClick = onLinearClick,
                onLinearClick = onTitleClick,
                titleContent = {    // Slot
                    if(imageSelected) {
                        titleImage(drawing = R.drawable.baseline_cloud_download_24)
                    }else {
                        Text("Downloading",
                            style = MaterialTheme.typography.headlineSmall,
                            modifier = Modifier.padding(30.dp))
                    }
                },
                progressContent = { // Slot
                    if(linearSelected) {
                        LinearProgressIndicator(Modifier.height(40.dp))
                    }else {
                        CircularProgressIndicator(Modifier.size(200.dp), strokeWidth = 18.dp)
                    }
                }
            )
        }

        /*
            titleContent , progressContent 컴포즈 함수를 파라미터로 받는다.
         */
        @Composable
        fun screenContent(linearSelected : Boolean ,
                          imageSelected : Boolean ,
                          onTitleClick: (Boolean) -> Unit,
                          onLinearClick: (Boolean) -> Unit,
                          titleContent: @Composable () -> Unit,
                          progressContent : @Composable () -> Unit) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                titleContent()
                progressContent()
                checkBoxes(linearSelected,imageSelected,onTitleClick,onLinearClick)
            }
        }

        @Composable
        fun checkBoxes(linearSelected: Boolean,
                       imageSelected: Boolean,
                       onTitleClick: (Boolean) -> Unit,
                       onLinearClick: (Boolean) -> Unit) {
            Row(
                Modifier.padding(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                     checked = imageSelected,
                    onCheckedChange = onTitleClick
                )
                Text("Image Title")
                Spacer(Modifier.width(20.dp))
                Checkbox(
                    checked = linearSelected,
                    onCheckedChange = onLinearClick
                )
                Text("Linear Progress")
            }
        }

        @Composable
        fun titleImage(drawing: Int) {
            Image(
                painter = painterResource(id = drawing),
                contentDescription = "title image"
            )
        }
    }
}