package com.acm431.huzuratlasi.ui.theme

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HuzurAtlasApp() {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Huzur Atlası") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        },
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) { innerPadding ->
        // Sayfaların içeriği burada yüklenir
        NavigationHost(navController = navController, modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        BottomNavItem("Ana Sayfa", "home", Icons.Default.Home),
        BottomNavItem("İlaçlarım", "medicine", Icons.Default.MedicalServices),
        BottomNavItem("Acil", "emergency", Icons.Default.Warning),
        BottomNavItem("Haberler", "news", Icons.Default.Article),
        BottomNavItem("Harita", "map", Icons.Default.Map),
    )

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.primaryContainer
    ) {
        val currentRoute by navController.currentBackStackEntryAsState()
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(imageVector = item.icon, contentDescription = item.title) },
                label = { Text(text = item.title) },
                selected = currentRoute?.destination?.route == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = MaterialTheme.colorScheme.onSurface,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    indicatorColor = MaterialTheme.colorScheme.secondary
                )
            )
        }
    }
}

// NavigationHost: Tüm ekranlar burada tanımlanır ve yönetilir
@Composable
fun NavigationHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = modifier
    ) {
        composable("home") { HomeScreen() }
        composable("medicine") { MedicineScreen() }
        composable("emergency") { EmergencyScreen() }
        composable("news") { NewsScreen() }
        composable("map") { MapScreen() }
    }
}

// Örnek ekranlar
@Composable
fun HomeScreen() {
    Text(text = "Ana Sayfa", style = MaterialTheme.typography.bodyLarge)
}

@Composable
fun MedicineScreen() {
    Text(text = "İlaçlarım", style = MaterialTheme.typography.bodyLarge)
}

@Composable
fun EmergencyScreen() {
    Text(text = "Acil Durum", style = MaterialTheme.typography.bodyLarge)
}

@Composable
fun NewsScreen() {
    Text(text = "Haberler", style = MaterialTheme.typography.bodyLarge)
}

@Composable
fun MapScreen() {
    Text(text = "Harita", style = MaterialTheme.typography.bodyLarge)
}

// Veri Sınıfı: Alt gezinme çubuğu öğeleri için
data class BottomNavItem(val title: String, val route: String, val icon: ImageVector)



