package com.acm431.huzuratlasi.ui.theme

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // SharedPreferences'i başlatıyoruz
        sharedPreferences = getSharedPreferences("OnboardingPrefs", MODE_PRIVATE)

        // Eğer onboarding daha önce görülmediyse OnboardingActivity'ye yönlendir
        val isOnboardingSeen = sharedPreferences.getBoolean("isOnboardingSeen", false)
        if (!isOnboardingSeen) {
            val intent = Intent(this, OnboardingActivity1::class.java)
            startActivity(intent)
            finish()
            return // OnboardingActivity'ye yönlendikten sonra devam etmesini engelle
        }

        // Ana ekranı Compose ile set ediyoruz
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Column(modifier = androidx.compose.ui.Modifier.fillMaxSize()) {
        // Ana navigasyon yapısı
        NavHost(
            navController = navController,
            startDestination = "home" // Varsayılan başlangıç ekranı
        ) {
            // **Ana Sayfa**
            composable("home") {
                HomeScreen(navController = navController)
            }

            // **İlaçlarım Sayfası**
            composable("medicine") {
                MedicineScreen(navController = navController)
            }

            // **Acil Durum Sayfası**
            composable("emergency") {
                EmergencyCase(navController = navController)
            }

            // **Haberler Sayfası**
            composable("news") {
                NewsScreen(navController = navController)
            }

            // **Harita Sayfası**
            composable("map") {
                MapScreen(navController = navController)
            }
        }

        // Alt Navigasyon Barı
        BottomNavigationBar(navController = navController)
    }
}

@Composable
fun MapScreen(navController: NavHostController) {

}

@Composable
fun NewsScreen(navController: NavHostController) {

}

@Composable
fun EmergencyCase(navController: NavHostController) {

}

@Composable
fun MedicineScreen(navController: NavHostController) {
    TODO("Not yet implemented")
}
