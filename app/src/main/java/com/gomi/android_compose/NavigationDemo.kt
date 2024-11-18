package com.gomi.android_compose

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gomi.android_compose.screens.Home
import com.gomi.android_compose.screens.Profile
import com.gomi.android_compose.screens.Welcome

class NavigationDemo {
    @Composable
    fun mainScreen() {
        val home = Home()
        val welcome = Welcome()
        val profile = Profile()
        val navController = rememberNavController()
        /*
            NavController : 네비게이션을 제어하는 객체. NavHost와 상호작용 하여 Navigation Graph 내에서 목적지간 이동을 관리.
            NavHost : 루트들을 표시하기 위한 화면전환이 발생시키는 객체.
            Navigation Graph : 네비에기션 구조를 정의. 앱에서 사용되는 모든 destination과 루트간의 행위들이 포함.

         */
        NavHost(navController = navController,
            startDestination = NavRoutes.HOME.route) {
            // Navigation Graph 시작
            composable(NavRoutes.HOME.route) {
                home.Home(navController = navController)
            }

            /*
                composable()  : 네비게이션 그래프의 루트를 정의하고 루트에 대한 컴포저블 화면을 설정.
                NavBackStackEntry : 네비게이션의 백스택 항목들. 이전화면의 argument나 상태에 접근할 수 있음.
                backStackEntry :
             */
            composable(NavRoutes.WELCOME.route+"/{userName}") { backStackEntry ->
                val userName = backStackEntry.arguments?.getString("userName")
                welcome.welCome(navController = navController,userName)
            }

            composable(NavRoutes.PROFILE.route) {
                profile.profile()
            }
        }
    }
}