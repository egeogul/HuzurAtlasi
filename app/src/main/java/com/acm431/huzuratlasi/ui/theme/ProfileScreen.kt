package com.acm431.huzuratlasi.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.acm431.huzuratlasi.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavHostController) {
    val currentRoute = navController.currentBackStackEntry?.destination?.route
    
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController, currentRoute = currentRoute)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Profile Header
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.primary,
                tonalElevation = 8.dp
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Surface(
                        modifier = Modifier.size(100.dp),
                        shape = CircleShape,
                        color = MaterialTheme.colorScheme.primaryContainer
                    ) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Profile Picture",
                            modifier = Modifier
                                .padding(16.dp)
                                .size(64.dp),
                            tint = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Ahmet Yılmaz",
                        style = MaterialTheme.typography.headlineMedium,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "ahmet.yilmaz@email.com",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.White.copy(alpha = 0.8f)
                    )
                }
            }

            // Profile Content
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                // Personal Information Section
                ProfileSection(
                    title = "Kişisel Bilgiler",
                    icon = Icons.Default.Person
                ) {
                    ProfileMenuItem(
                        icon = Icons.Default.Phone,
                        title = "Telefon",
                        subtitle = "+90 555 123 4567"
                    )
                    ProfileMenuItem(
                        icon = Icons.Default.LocationOn,
                        title = "Adres",
                        subtitle = "İstanbul, Türkiye"
                    )
                    ProfileMenuItem(
                        icon = Icons.Default.Cake,
                        title = "Doğum Tarihi",
                        subtitle = "01.01.1980"
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Medical Information Section
                ProfileSection(
                    title = "Sağlık Bilgileri",
                    icon = Icons.Default.HealthAndSafety
                ) {
                    ProfileMenuItem(
                        icon = Icons.Default.MedicalServices,
                        title = "Kan Grubu",
                        subtitle = "A Rh+"
                    )
                    ProfileMenuItem(
                        icon = Icons.Default.LocalHospital,
                        title = "Alerji",
                        subtitle = "Yok"
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Emergency Button
                Button(
                    onClick = { navController.navigate("emergency") },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(16.dp)
                ) {
                    Icon(
                        Icons.Default.Warning,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        "Acil Durum",
                        style = MaterialTheme.typography.titleMedium
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Settings Section
                ProfileSection(
                    title = "Ayarlar",
                    icon = Icons.Default.Settings
                ) {
                    ProfileMenuItem(
                        icon = Icons.Default.Notifications,
                        title = "Bildirimler",
                        onClick = { /* Handle notifications settings */ }
                    )
                    ProfileMenuItem(
                        icon = Icons.Default.Security,
                        title = "Gizlilik",
                        onClick = { /* Handle privacy settings */ }
                    )
                    ProfileMenuItem(
                        icon = Icons.Default.ExitToApp,
                        title = "Çıkış Yap",
                        onClick = { navController.navigate("login") }
                    )
                }
            }
        }
    }
}

@Composable
fun ProfileSection(
    title: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    content: @Composable () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
            }
            content()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileMenuItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    subtitle: String? = null,
    onClick: (() -> Unit)? = null
) {
    Surface(
        onClick = { onClick?.invoke() },
        modifier = Modifier.fillMaxWidth(),
        enabled = onClick != null
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary.copy(alpha = 0.7f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyLarge
                )
                if (subtitle != null) {
                    Text(
                        text = subtitle,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                    )
                }
            }
            if (onClick != null) {
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.ChevronRight,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f)
                )
            }
        }
    }
} 