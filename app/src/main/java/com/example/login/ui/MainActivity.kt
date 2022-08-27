package com.example.login.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.login.ui.features.LoginScreen
import com.example.login.ui.features.RegisterScreen
import com.example.login.ui.theme.LoginTheme
import com.example.login.util.MyScreens

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginTheme {
                MainUI()
            }
        }
    }
}

@Composable
fun MainUI() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MyScreens.LoginScreen.route) {
        composable(route = MyScreens.LoginScreen.route) {
            LoginScreen(navController = navController)
        }

        composable(route = MyScreens.RegisterScreen.route) {
            RegisterScreen(navController = navController)
        }
    }

}
