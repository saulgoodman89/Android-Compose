package com.gomi.android_compose

sealed class NavRoutes(val route:String) {
    object HOME : NavRoutes("home")
    object WELCOME : NavRoutes("welcome")
    object PROFILE : NavRoutes("profile")
}