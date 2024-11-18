package com.gomi.android_compose.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.gomi.android_compose.NavRoutes

class Welcome {
    @Composable
    fun welCome(navController : NavHostController , userName: String?) {
        Box(
          modifier = Modifier
              .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Welcome $userName",style = MaterialTheme.typography.headlineSmall)
                Spacer(modifier = Modifier.size(30.dp))
                Button(onClick = {
                    /*

                        navigate() : 화면에서 다른 화면으로 이동 할 때 사용.
                        popUpTo() : 네비게이션 스택에서 특정 굥로까지 화면들을 제거.
                        아래 코드에서 홈 하면 위의 모든 화면을 제거. 백스택에는 홈화면과 프로파일 화면만 남음.
                     */
                    navController.navigate(NavRoutes.PROFILE.route) {
                        popUpTo(NavRoutes.HOME.route)
                    }
                }) {
                    Text(text = "Set up your Profile")
                }
            }
        }
    }
}