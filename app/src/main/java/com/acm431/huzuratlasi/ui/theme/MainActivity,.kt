package com.acm431.huzuratlasi.ui.theme

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.acm431.huzuratlasi.ui.theme.OnboardingActivity // OnboardingActivity'yi doğru import edin
import com.acm431.huzuratlasi.R // Projenin otomatik oluşturulan R sınıfını import edin

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // SharedPreferences'i başlatıyoruz
        sharedPreferences = getSharedPreferences("OnboardingPrefs", MODE_PRIVATE)

        // Eğer onboarding daha önce görülmediyse OnboardingActivity'ye yönlendir
        val isOnboardingSeen = sharedPreferences.getBoolean("isOnboardingSeen", false)
        if (!isOnboardingSeen) {
            val intent = Intent(this, OnboardingActivity::class.java)
            startActivity(intent)
            finish()
            return // OnboardingActivity'ye yönlendikten sonra devam etmesini engelle
        }

        // Ana ekran layout'unuzu burada set edin
        setContentView(R.layout.activity_main)
    }
}
