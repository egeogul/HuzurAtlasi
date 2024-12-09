package com.acm431.huzuratlasi.ui.theme

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.acm431.huzuratlasi.R

class OnboardingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Doğru layout dosyasını kullanın
        setContentView(R.layout.activity_onboarding)

        // "Sonraki" butonuna tıklama olayı ekleyin
        val nextButton = findViewById<Button>(R.id.next_button) // Button ID'yi doğru kontrol edin
        nextButton.setOnClickListener {
            // MainActivity'ye geçiş
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Onboarding ekranını kapat
        }
    }
}

