package com.example.login.util

sealed class MyScreens(val route:String){
    object LoginScreen :MyScreens("loginScreen")
    object RegisterScreen :MyScreens("registerScreen")
}
