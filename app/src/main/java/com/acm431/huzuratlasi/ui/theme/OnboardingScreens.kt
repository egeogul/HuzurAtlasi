package com.acm431.huzuratlasi.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.acm431.huzuratlasi.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Onboarding1(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        // Logo
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier.size(90.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Illustration
        Image(
            painter = painterResource(id = R.drawable.onb1),
            contentDescription = "Illustration",
            modifier = Modifier.size(400.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

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

        Spacer(modifier = Modifier.weight(1f))

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

        Spacer(modifier = Modifier.height(24.dp))

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

        Spacer(modifier = Modifier.height(24.dp))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Onboarding2(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        // Logo
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier.size(90.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Illustration
        Image(
            painter = painterResource(id = R.drawable.onb2),
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
                text = "Başla",
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