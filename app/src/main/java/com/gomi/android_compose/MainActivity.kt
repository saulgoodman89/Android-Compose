package com.gomi.android_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderPositions
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gomi.android_compose.ui.theme.AndroidComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    DemoScreen()
                }
            }
        }
    }
}


/*
    @Preview
    안스에서 빌드없이 디자인을 확인하기 위해 사용.

 */
@Preview
@Composable
fun DemoTextPreview() {
    DemoText(message = "Welcome to Android", fontSize =25f)
}

@Composable
fun DemoText(message: String , fontSize: Float , modifier : Modifier = Modifier) {
    Text(
        text=message,
        fontSize = fontSize.sp,
        fontWeight = FontWeight.Bold,
        modifier = modifier
    )
}


@Composable
fun DemoSlider(sliderPositions: Float , onPositionChange : (Float) -> Unit) {
    Slider(modifier = Modifier.padding(10.dp),
        value = sliderPositions,
        valueRange = 20f..40f,
        onValueChange = {onPositionChange(it)})
}

@Composable
fun DemoScreen() {
    /*
        mutableStateOf
            Jetpack Compose 에서 상태를 관리하기 위해 사용하는 함수.
            상태 저장용 객체이며 상태가 변경될 때 Compose 프레임워크에 알려 UI를 자동으로 갱신하게 도와준다.
        remember
            컴포저블 함수 내에 상태를 저장하고 , 컴포저블이 재구성될 때 상태 유지하도록 한다.

         sliderPosition 값이 변경되면 컴포즈가 이를 감지하고
         해당 변수를 읽는  컴포저블 함수를 재구성해 UI 업데이트를 진행.
     */
    var sliderPosition by remember {
        mutableStateOf(20f)
    }

    val handlePositionChange = {position : Float ->
        sliderPosition = position
    }

    /*
        Flutter의 Column과 같음.
     */
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    )  {
        DemoText(message = "Welcom to Compose", fontSize = sliderPosition)
        Spacer(modifier = Modifier.height(150.dp))
        
        DemoSlider(
            sliderPositions = sliderPosition,
            onPositionChange = handlePositionChange
        )

        Text(
            style = MaterialTheme.typography.headlineMedium,
            text = sliderPosition.toInt().toString() + "sp"
        )
    }
        
    
}