package com.acm431.huzuratlasi.ui.theme

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.acm431.huzuratlasi.R
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment


@Composable
fun EmergencyCaseScreen(onNavigateToHome: () -> Unit) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

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
        )  {
            Text(
                text = stringResource(R.string.home_button_text),
                color = TextColor,
                style = MaterialTheme.typography.labelLarge,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun EmergencyCaseScreenPreview() {
    HuzurAtlasıTheme {
        Surface {
            EmergencyCaseScreen(onNavigateToHome = {})
        }
    }
}