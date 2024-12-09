package com.acm431.huzuratlasi.ui.theme

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.acm431.huzuratlasi.R // R sınıfını projenizin ana paketinden import edin

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // activity_profile.xml dosyasını bu aktivite ile ilişkilendiriyoruz
        setContentView(R.layout.activity_profile)
    }
}

