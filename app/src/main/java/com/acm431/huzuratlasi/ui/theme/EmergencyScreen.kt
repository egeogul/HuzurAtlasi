package com.acm431.huzuratlasi.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.acm431.huzuratlasi.R

@Composable
fun EmercencyCaseScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = LightBackground).padding(top=50.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp)// Açık arka plan rengi
    ) {
        // Başlık

        Text(
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            text = stringResource(R.string.emergencycase),
            style = MaterialTheme.typography.labelLarge,
            color = TextColor, // Siyah yazı rengi
            modifier = Modifier
                .fillMaxWidth()
                .background(LightBackground)
        )

        // İkon ve Buton Satırı
        Row(modifier = Modifier.fillMaxWidth()) {
            // Ambulans Butonu
            Button(
                onClick = {},
                modifier = Modifier.weight(1f),
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = ButtonColor // Kırmızı arka plan
                )
            ) {
                Image(
                    painter = painterResource(R.drawable.ambulans),
                    contentDescription = "Ambulans",
                    modifier = Modifier.size(120.dp),
                )
            }

            // Polis Butonu
            Button(
                onClick = {},
                modifier = Modifier.weight(1f),
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = ButtonColor // Kırmızı arka plan
                )
            ) {
                Image(
                    painter = painterResource(R.drawable.polis),
                    contentDescription = "Polis",
                    modifier = Modifier.size(120.dp),
                )
            }

            // İtfaiye Butonu
            Button(
                onClick = {},
                modifier = Modifier.weight(1f),
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = ButtonColor // Kırmızı arka plan
                )
            ) {
                Image(
                    painter = painterResource(R.drawable.itfaiye),
                    contentDescription = "İtfaiye",
                    modifier = Modifier.size(120.dp),
                )
            }
        }
    }
}
@Preview(showSystemUi = true)
@Composable
fun EmercencyCaseScreenPreview() {
    HuzurAtlasıTheme { Surface { EmercencyCaseScreen() }
        EmercencyCaseScreen()
    }}

