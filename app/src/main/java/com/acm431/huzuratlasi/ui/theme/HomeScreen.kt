package com.acm431.huzuratlasi.ui.theme

import android.widget.CalendarView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController) // Alt gezinme çubuğu eklendi
        },
        content = { paddingValues ->
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues), // Scaffold'dan gelen padding'i uygula
                color = MaterialTheme.colorScheme.background
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())

                ) {

                    // Harita Placeholder
                    Text(
                        text = "Haberler",
                        style = MaterialTheme.typography.headlineSmall
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .background(Color.Gray, MaterialTheme.shapes.medium),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "Burada haberler görünecek", color = Color.White)
                    }

                    // Keşfet Bölümü
                    Text(
                        text = "Keşfet",
                        style = MaterialTheme.typography.headlineSmall
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Box(
                            modifier = Modifier
                                .size(80.dp)
                                .background(Color.LightGray, MaterialTheme.shapes.medium),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "Haberler")
                        }
                        Box(
                            modifier = Modifier
                                .size(80.dp)
                                .background(Color.LightGray, MaterialTheme.shapes.medium),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "Raporlarım")
                        }
                        Box(
                            modifier = Modifier
                                .size(80.dp)
                                .background(Color.LightGray, MaterialTheme.shapes.medium),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "İlaçlarım")
                        }
                    }

                    // Takvim
                    Text(
                        text = "Takvim",
                        style = MaterialTheme.typography.headlineSmall
                    )
                    AndroidView(
                        factory = { context ->
                            CalendarView(context).apply {
                                setOnDateChangeListener { _, year, month, dayOfMonth ->
                                    // Tarih seçimi işlemleri
                                }
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                    )
                }
            }
        }
    )
}
