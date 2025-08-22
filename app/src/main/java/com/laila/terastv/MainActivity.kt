package com.laila.terastv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.laila.terastv.ui.dashboard.DashboardScreen
import com.laila.terastv.ui.registration.RegistrationScreen
import com.laila.terastv.ui.splash.SplashScreen
import com.laila.terastv.ui.theme.TerasTVTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TerasTVTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
//                    AppNavigation()
                }
            }
        }
    }
}

//@Composable
//fun AppNavigation() {
//    val navController = rememberNavController()
//
//    NavHost(navController = navController, startDestination = "splash") {
//
//        composable("splash") {
//            SplashScreen(
//                durationMillis = 2000,
//                onFinished = {
//                    // 👉 di sini kamu cek status registrasi (contoh pakai dummy boolean)
//                    val alreadyRegistered = false // ganti dengan SharedPreferences / DataStore
//                    if (alreadyRegistered) {
//                        navController.navigate("dashboard") {
//                            popUpTo("splash") { inclusive = true }
//                        }
//                    } else {
//                        navController.navigate("registration") {
//                            popUpTo("splash") { inclusive = true }
//                        }
//                    }
//                }
//            )
//        }
//
//        composable("registration") {
//            RegistrationScreen(
//                onRegisterSuccess = {
//                    navController.navigate("dashboard") {
//                        popUpTo("registration") { inclusive = true }
//                    }
//                }
//            )
//        }
//
//        composable("dashboard") {
//            DashboardScreen(
//                onAboutClick = { /* navController.navigate("about") */ }
//            )
//        }
//    }
//}
