package com.acm431.huzuratlasi.ui.theme

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Accessibility
import androidx.compose.material.icons.filled.Article
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.MedicalServices
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.acm431.huzuratlasi.R
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // SharedPreferences'i başlatıyoruz
        sharedPreferences = getSharedPreferences("OnboardingPrefs", MODE_PRIVATE)

        // Onboarding durumu kontrolü
        val isOnboardingSeen = sharedPreferences.getBoolean("isOnboardingSeen", false)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        // Ana ekranı Compose ile set ediyoruz
            setContent {
           MainScreen(isOnboardingSeen)
        }
    }
}

@Composable
fun MainScreen(isOnboardingSeen: Boolean) {
    val navController = rememberNavController()
    val systemUiController = rememberSystemUiController()


    Column(modifier = Modifier.fillMaxSize()) {
        NavHost(
            navController = navController,
            startDestination = if (isOnboardingSeen) "login" else "onboarding1" // Start with login if onboarding seen
        ) {
            composable("onboarding1") { Onboarding1(navController = navController) }
            composable("onboarding2") { Onboarding2(navController = navController) }
            composable("home") { HomeScreen(navController = navController) }
            composable("medicine") { MedicineScreen(navController = navController) }
            composable("emergency") { EmergencyCase(navController = navController) }
            composable("news") { NewsScreen(navController = navController) }
            composable("map") { MapScreen(navController = navController) }
            composable("profile") { ProfileScreen(navController = navController) }
            composable("login") { LoginPage(navController = navController) } // Add LoginPage route
            composable("emergency") { EmergencyCase(navController = navController) // Pass navController here
            }
        }

        }


    }


@Composable
fun LoginPage(navController: NavController) {
    // Metinleri tutmak için state'ler
    var name by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFF8FFF4)) // Açık arka plan rengi
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Logo
        Image(
            painter = painterResource(id = R.drawable.logo), // Logo kaynağını değiştir
            contentDescription = "Uygulama Logosu",
            modifier = Modifier
                .size(150.dp)
                .padding(top = 32.dp, bottom = 16.dp)
        )

        // Başlık
        Text(
            text = "Huzur Atlası",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFD32F2F) // Kırmızı renk
        )

        Text(
            text = "Sağlık Yönetimi Uygulaması",
            fontSize = 16.sp,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        // Giriş Formu
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = name,
                onValueChange = { name = it }, // state güncelleme
                label = { Text("İsim Soyisim") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.person),
                        contentDescription = "Kullanıcı İkonu"
                    )
                }
            )

            OutlinedTextField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it }, // state güncelleme
                label = { Text("Telefon Numarası") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.telefonikonyeni),
                        contentDescription = "Telefon İkonu"
                    )
                }
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it }, // state güncelleme
                label = { Text("Şifre") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.passwordicon24),
                        contentDescription = "Şifre İkonu"
                    )
                }
            )

            OutlinedTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it }, // state güncelleme
                label = { Text("Şifre Tekrar") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.passwordicon24),
                        contentDescription = "Şifre Tekrar İkonu"
                    )
                }
            )
        }

        // Kayıt Ol Butonu
        Button(
            onClick = { navController.navigate("home") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD32F2F)),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = "Kayıt Ol", color = Color.White)
        }

        // Alternatif Giriş
        Text(
            text = "veya",
            color = Color.Gray,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        Button(
            onClick = { /* Google ile giriş işlemi */ },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4285F4)), // Google mavi renk
            shape = RoundedCornerShape(8.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.accountcircle), // Google ikonu
                    contentDescription = "Google İkonu",
                    tint = Color.White
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Google ile oturum açın", color = Color.White)
            }
        }
    }
}


@Composable
fun Onboarding1(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        androidx.compose.foundation.layout.Spacer(modifier = Modifier.height(24.dp))

        // Logo
        Image(
            painter = painterResource(id = R.drawable.logo), // Replace
            // with your logo drawable resource
            contentDescription = "Logo",
            modifier = Modifier.size(90.dp)
        )

        androidx.compose.foundation.layout.Spacer(modifier = Modifier.height(24.dp))

        // Illustration
        Image(
            painter = painterResource(id = R.drawable.onb1), // Replace with your illustration drawable resource
            contentDescription = "Illustration",
            modifier = Modifier.size(400.dp)
        )

        androidx.compose.foundation.layout.Spacer(modifier = Modifier.height(24.dp))

        // Description text
        Text(
            text = "Bu mobil uygulama, sizlerin günlük yaşamlarını kolaylaştırmayı, sağlık hizmetlerine erişimlerini artırmayı ve sosyal etkileşimlerini güçlendirmeyi hedeflemektedir.",
            style = TextStyle(
                fontSize = 22.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            ),
            modifier = Modifier.padding(horizontal = 18.dp),
            lineHeight = 22.sp
        )

        androidx.compose.foundation.layout.Spacer(modifier = Modifier.weight(1f))

        // Page Indicator
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(4) { index ->
                val color = if (index == 0) Color.DarkGray else Color.LightGray
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .padding(4.dp)
                        .background(color = color, shape = CircleShape)
                )
            }
        }

        androidx.compose.foundation.layout.Spacer(modifier = Modifier.height(24.dp))

        // Next button
        Button(
            onClick = { navController.navigate("onboarding2") },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF002366)),
            modifier = Modifier.fillMaxWidth(0.8f)
        ) {
            Text(
                text = "İleri",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            )
        }

        androidx.compose.foundation.layout.Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
fun Onboarding2(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        // Logo
        Image(
            painter = painterResource(id = R.drawable.logo), // Replace
            // with your logo drawable resource
            contentDescription = "Logo",
            modifier = Modifier.size(90.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Illustration
        Image(
            painter = painterResource(id = R.drawable.onb2), // Replace with your illustration drawable resource
            contentDescription = "Illustration",
            modifier = Modifier.size(400.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Description text
        Text(
            text = "Sizlere ilaç saatlerini hatırlatır, acil durumlarda ambulans çağırma olanağı sağlar, önemli tarihlerin takip edilebileceği bir takvim sunar ve haberler sunar. \n",
            style = TextStyle(
                fontSize = 22.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            ),
            modifier = Modifier.padding(horizontal = 18.dp),
            lineHeight = 22.sp
        )

        Spacer(modifier = Modifier.weight(1f))

        // Page Indicator
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(4) { index ->
                val color = if (index == 1) Color.DarkGray else Color.LightGray
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .padding(4.dp)
                        .background(color = color, shape = CircleShape)
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Next button
        Button(
            onClick = { navController.navigate("login") },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF002366)),
            modifier = Modifier.fillMaxWidth(0.8f)
        ) {
            Text(
                text = "İleri",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            )
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
fun Spacer(modifier: Modifier) {

}

@Composable
fun HomeScreenPage(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Home Screen")
    }
}

@Composable
fun MedicineScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Medicine Screen")
    }
}

@Composable
fun EmergencyCase(navController: NavHostController) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    val onNavigateToHome: () -> Unit = {
        navController.navigate("home") {
            popUpTo(navController.graph.startDestinationId) {
                inclusive = true
            }
            launchSingleTop = true
        }
    }
    // Launcher for permission request
    val callPermissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (!isGranted) {
            // Handle permission denied (optional: show a Toast or dialog)
        }
    }

    fun makePhoneCall(context: Context, phoneNumber: String) {
        // Check if permission is granted
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:$phoneNumber"))
            context.startActivity(intent)
        } else {
            // Request the permission
            callPermissionLauncher.launch(Manifest.permission.CALL_PHONE)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = LightBackground)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Title
        Text(
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            text = stringResource(R.string.emergencycase),
            style = MaterialTheme.typography.labelLarge,
            color = TextColor,
            modifier = Modifier
                .fillMaxWidth()
                .background(LightBackground)
        )

        // Row with buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Ambulance Button
            Button(
                onClick = { makePhoneCall(context, "112") },
                modifier = Modifier
                    .size(100.dp), // Kare buton
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = ButtonColor
                )
            ) {
                Image(
                    painter = painterResource(R.drawable.ambulans),
                    contentDescription = "Ambulans",
                    modifier = Modifier.size(60.dp),
                )
            }

            // Police Button
            Button(
                onClick = { makePhoneCall(context, "155") },
                modifier = Modifier
                    .size(100.dp), // Kare buton
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = ButtonColor
                )
            ) {
                Image(
                    painter = painterResource(R.drawable.polis),
                    contentDescription = "Polis",
                    modifier = Modifier.size(60.dp),
                )
            }

            // Fire Department Button
            Button(
                onClick = { makePhoneCall(context, "110") },
                modifier = Modifier
                    .size(100.dp), // Kare buton
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = ButtonColor
                )
            ) {
                Image(
                    painter = painterResource(R.drawable.itfaiye),
                    contentDescription = "İtfaiye",
                    modifier = Modifier.size(60.dp),
                )
            }
        }

        // Spacer for separation
        Spacer(modifier = Modifier.height(30.dp))

        // Home Button
        Button(
            onClick = { onNavigateToHome() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                containerColor = ButtonColor
            )
        ) {
            Text(
                text = stringResource(R.string.home_button_text),
                color = TextColor,
                style = MaterialTheme.typography.labelLarge,
                textAlign = TextAlign.Center
            )
        }
    }
}

fun onNavigateToHome() {
    TODO("Not yet implemented")
}

@Composable
fun NewsScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("News Screen")
    }
}

@Composable
fun MapScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Map Screen")
    }
}
@Composable
fun ProfileScreen(navController: NavHostController) {
    val onNavigateToHome: () -> Unit = {
        navController.navigate("home") {
            popUpTo(navController.graph.startDestinationId) {
                inclusive = true
            }
            launchSingleTop = true
        }
    }
    var name by remember { mutableStateOf("Bora") }
    var birthDate by remember { mutableStateOf("01/01/1980") }
    var age by remember { mutableStateOf("44") }
    var height by remember { mutableStateOf("180 cm") }
    var weight by remember { mutableStateOf("75 kg") }
    var bmi by remember { mutableStateOf("23.1") }
    var bloodType by remember { mutableStateOf("A+") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.light_background))
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Üst Kısım: Merhaba ve Fotoğraf
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Merhaba, Bora
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Merhaba, $name",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.black),
                    modifier = Modifier.padding(start = 40.dp)
                )
                Image(
                    painter = painterResource(R.drawable.default_avatar),
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                )
            }

            // Profil Fotoğrafı
            Image(
                painter = painterResource(R.drawable.default_avatar), // Profil fotoğrafı
                contentDescription = "Profile Image",
                modifier = Modifier
                    .size(180.dp)
                    .padding(vertical = 16.dp)
                    .clip(CircleShape)
            )
        }

        // Orta Kısım: Bilgiler
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Doğum Tarihi ve Yaş
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                InfoTextField(value = birthDate, onValueChange = { birthDate = it }, label = "Doğum Tarihi")
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                InfoTextField(value = age, onValueChange = { age = it }, label = "Yaş")

            }
            // İsim Soyisim ve Kan Grubu
            InfoTextField(value = name, onValueChange = { name = it }, label = "İsim Soyisim")
            InfoTextField(value = bloodType, onValueChange = { bloodType = it }, label = "Kan Grubu")
            // Boy ve Kilo
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                InfoTextField(value = height, onValueChange = { height = it }, label = "Boy")

            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                InfoTextField(value = weight, onValueChange = { weight = it }, label = "Kilo")
            }
        }

        // Alt Kısım: Ana Sayfa ve Kaydet Butonları
        Button(
            onClick = { onNavigateToHome() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                containerColor = ButtonColor
            )
        ) {
            Text(
                text = stringResource(R.string.home_button_text),
                color = TextColor,
                style = MaterialTheme.typography.labelLarge,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun InfoTextField(value: String, onValueChange: (String) -> Unit, label: String) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,

        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        shape = RoundedCornerShape(20.dp)
    )
}

@Composable
fun BottomNavigationBar(navController: NavController, currentRoute: String?) {
    NavigationBar(
        containerColor = Color.Red // Set background color to red
    ) {
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("home") },
            label = { Text("Ana Sayfa", color = Color.White) }, // Set label color to white
            icon = { Icon(Icons.Default.Home, contentDescription = null, tint = Color.White) } // Set icon tint to white
        )
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("medicine") },
            label = { Text("İlaçlarım", color = Color.White) }, // Set label color to white
            icon = { Icon(Icons.Default.MedicalServices, contentDescription = null, tint = Color.White) } // Set icon tint to white
        )
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("emergency") },
            label = { Text("Acil Durum", color = Color.White) }, // Set label color to white
            icon = { Icon(Icons.Default.Warning, contentDescription = null, tint = Color.White) } // Set icon tint to white
        )
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("news") },
            label = { Text("Haberler", color = Color.White) }, // Set label color to white
            icon = { Icon(Icons.Default.Article, contentDescription = null, tint = Color.White) } // Set icon tint to white
        )
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("profile") },
            label = { Text("Profilim", color = Color.White) }, // Set label color to white
            icon = { Icon(Icons.Default.Accessibility, contentDescription = null, tint = Color.White) } // Set icon tint to white
        )
    }
}

