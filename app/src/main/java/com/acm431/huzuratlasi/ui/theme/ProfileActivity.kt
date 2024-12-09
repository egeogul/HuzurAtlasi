package com.acm431.huzuratlasi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // activity_profile.xml dosyasını bu aktivite ile ilişkilendiriyoruz
        setContentView(R.layout.activity_profile)
    }
}
