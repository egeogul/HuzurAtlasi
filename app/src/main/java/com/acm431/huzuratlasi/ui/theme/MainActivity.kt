package com.acm431.huzuratlasi.ui.theme

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Article
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.MedicalServices
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // SharedPreferences'i başlatıyoruz
        sharedPreferences = getSharedPreferences("OnboardingPrefs", Context.MODE_PRIVATE)

        // Onboarding durumu kontrolü
        val isOnboardingSeen = sharedPreferences.getBoolean("isOnboardingSeen", false)

        // Ana ekranı Compose ile set ediyoruz
        setContent {
            MainScreen(isOnboardingSeen)
        }
    }
}

@Composable
fun MainScreen(isOnboardingSeen: Boolean) {
    val navController = rememberNavController()

    Column(modifier = Modifier.fillMaxSize()) {
        // Başlangıç ekranı duruma göre ayarlanıyor
        NavHost(
            navController = navController,
            startDestination = if (isOnboardingSeen) "home" else "onboarding1"
        ) {
            // Onboarding 1 ekranı
            composable("onboarding1") {
                Onboarding1(navController = navController)
            }

            // Onboarding 2 ekranı
            composable("onboarding2") {
                Onboarding2(navController = navController)
            }

            // Ana Sayfa
            composable("home") {
                HomeScreen(navController = navController)
            }

            // İlaçlarım ekranı
            composable("medicine") {
                MedicineScreen(navController = navController)
            }

            // Acil Durum ekranı
            composable("emergency") {
                EmergencyCase(navController = navController)
            }

            // Haberler ekranı
            composable("news") {
                NewsScreen(navController = navController)
            }

            // Harita ekranı
            composable("map") {
                MapScreen(navController = navController)
            }
        }

        // Alt Navigasyon Barı sadece ana ekranlarda gösterilir
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
        if (currentRoute in listOf("home", "medicine", "map", "news", "emergency")) {
            BottomNavigationBar(navController = navController)
        }
    }
}

@Composable
fun Onboarding1(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center,
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        Text("Welcome to the App! This is Onboarding 1.")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("onboarding2") }) {
            Text("Next")
        }
    }
}

@Composable
fun Onboarding2(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center,
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        Text("This is Onboarding 2. Let's get started!")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            // Onboarding tamamlandı, durumu kaydet
            val sharedPreferences = navController.context.getSharedPreferences("OnboardingPrefs", Context.MODE_PRIVATE)
            sharedPreferences.edit().putBoolean("isOnboardingSeen", true).apply()
            navController.navigate("home")
        }) {
            Text("Finish")
        }
    }
}

@Composable
fun Spacer(modifier: Modifier) {

}

@Composable
fun HomeScreenPage(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center,
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        Text("Home Screen")
    }
}

@Composable
fun MedicineScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center,
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        Text("Medicine Screen")
    }
}

@Composable
fun EmergencyCase(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center,
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        Text("Emergency Screen")
    }
}

@Composable
fun NewsScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center,
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        Text("News Screen")
    }
}

@Composable
fun MapScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center,
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        Text("Map Screen")
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    NavigationBar(
        containerColor = Color.Red // Set background color to red
    ) {
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("home") },
            label = { Text("Home", color = Color.White) }, // Set label color to white
            icon = { Icon(Icons.Default.Home, contentDescription = null, tint = Color.White) } // Set icon tint to white
        )
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("medicine") },
            label = { Text("Medicine", color = Color.White) }, // Set label color to white
            icon = { Icon(Icons.Default.MedicalServices, contentDescription = null, tint = Color.White) } // Set icon tint to white
        )
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("emergency") },
            label = { Text("Emergency", color = Color.White) }, // Set label color to white
            icon = { Icon(Icons.Default.Warning, contentDescription = null, tint = Color.White) } // Set icon tint to white
        )
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("news") },
            label = { Text("News", color = Color.White) }, // Set label color to white
            icon = { Icon(Icons.Default.Article, contentDescription = null, tint = Color.White) } // Set icon tint to white
        )
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("map") },
            label = { Text("Map", color = Color.White) }, // Set label color to white
            icon = { Icon(Icons.Default.Map, contentDescription = null, tint = Color.White) } // Set icon tint to white
        )
    }
}

