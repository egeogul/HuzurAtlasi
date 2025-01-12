package com.acm431.huzuratlasi.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.Color

@Composable
fun BottomNavigationBar(navController: NavController, currentRoute: String?) {
    NavigationBar(
        containerColor = Color.Red
    ) {
        NavigationBarItem(
            selected = currentRoute == "home",
            onClick = { 
                if (currentRoute != "home") {
                    navController.navigate("home") {
                        popUpTo("home") { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            },
            label = { Text("Ana Sayfa", color = Color.White) },
            icon = { Icon(Icons.Default.Home, contentDescription = null, tint = Color.White) }
        )
        
        NavigationBarItem(
            selected = currentRoute == "medicine",
            onClick = { 
                if (currentRoute != "medicine") {
                    navController.navigate("medicine") {
                        popUpTo("home") { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            },
            label = { Text("İlaçlarım", color = Color.White) },
            icon = { Icon(Icons.Default.MedicalServices, contentDescription = null, tint = Color.White) }
        )
        
        NavigationBarItem(
            selected = currentRoute == "emergency",
            onClick = { 
                if (currentRoute != "emergency") {
                    navController.navigate("emergency") {
                        popUpTo("home") { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            },
            label = { Text("Acil Durum", color = Color.White) },
            icon = { Icon(Icons.Default.Warning, contentDescription = null, tint = Color.White) }
        )
        
        NavigationBarItem(
            selected = currentRoute == "news",
            onClick = { 
                if (currentRoute != "news") {
                    navController.navigate("news") {
                        popUpTo("home") { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            },
            label = { Text("Haberler", color = Color.White) },
            icon = { Icon(Icons.Default.Article, contentDescription = null, tint = Color.White) }
        )
        
        NavigationBarItem(
            selected = currentRoute == "profile",
            onClick = { 
                if (currentRoute != "profile") {
                    navController.navigate("profile") {
                        popUpTo("home") { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            },
            label = { Text("Profilim", color = Color.White) },
            icon = { Icon(Icons.Default.Accessibility, contentDescription = null, tint = Color.White) }
        )
    }
}


