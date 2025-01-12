package com.acm431.huzuratlasi.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import android.content.Intent
import android.net.Uri

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmergencyScreen(navController: NavHostController) {
    val currentRoute = navController.currentBackStackEntry?.destination?.route
    val context = LocalContext.current
    
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController, currentRoute = currentRoute)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            // Emergency Header
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = Color.Red,
                tonalElevation = 8.dp
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.Warning,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(48.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Acil Durum",
                        style = MaterialTheme.typography.headlineMedium,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Yardım için aşağıdaki seçenekleri kullanabilirsiniz",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.White.copy(alpha = 0.8f)
                    )
                }
            }

            // Quick Emergency Actions
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                // Emergency Call Buttons
                EmergencyCallButton(
                    title = "Ambulans Çağır (112)",
                    icon = Icons.Default.LocalHospital,
                    phoneNumber = "112"
                ) {
                    val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:112"))
                    context.startActivity(intent)
                }

                Spacer(modifier = Modifier.height(8.dp))

                EmergencyCallButton(
                    title = "Polis İmdat (155)",
                    icon = Icons.Default.LocalPolice,
                    phoneNumber = "155"
                ) {
                    val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:155"))
                    context.startActivity(intent)
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Emergency Contacts Section
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "Acil Durum Kişileri",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        EmergencyContact(
                            name = "Dr. Mehmet Yılmaz",
                            relation = "Aile Hekimi",
                            phone = "+90 555 123 4567"
                        ) {
                            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:+905551234567"))
                            context.startActivity(intent)
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        EmergencyContact(
                            name = "Ayşe Yılmaz",
                            relation = "Yakın Akraba",
                            phone = "+90 555 765 4321"
                        ) {
                            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:+905557654321"))
                            context.startActivity(intent)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Medical Information Card
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "Önemli Sağlık Bilgileri",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        MedicalInfo(title = "Kan Grubu", info = "A Rh+")
                        MedicalInfo(title = "Alerjiler", info = "Penisilin")
                        MedicalInfo(title = "Kronik Hastalıklar", info = "Hipertansiyon")
                        MedicalInfo(title = "Kullanılan İlaçlar", info = "Beloc, Coraspin")
                    }
                }
            }
        }
    }
}

@Composable
fun EmergencyCallButton(
    title: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    phoneNumber: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = phoneNumber,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White.copy(alpha = 0.8f)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmergencyContact(
    name: String,
    relation: String,
    phone: String,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = relation,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                )
                Text(
                    text = phone,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Icon(
                imageVector = Icons.Default.Phone,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Composable
fun MedicalInfo(
    title: String,
    info: String
) {
    Column(
        modifier = Modifier.padding(vertical = 4.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
        )
        Text(
            text = info,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}