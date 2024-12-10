package com.acm431.huzuratlasi.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.acm431.huzuratlasi.R
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember


@Composable
fun LoginScreen() {
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
            onClick = { /* Kayıt işlemi */ },
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

@Preview(showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}

