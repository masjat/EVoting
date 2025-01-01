package com.example.evoting.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.evoting.R

class LandingPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_page)

        // Button Login
        val buttonLogin: Button = findViewById(R.id.btLogin)
        buttonLogin.setOnClickListener {
            val intent = Intent(this, PageLogin::class.java)
            startActivity(intent)
        }

        // Button Register
        val buttonRegister: Button = findViewById(R.id.btRegister)
        buttonRegister.setOnClickListener {
            val intent = Intent(this, PageRegister::class.java)
            startActivity(intent)
        }
    }
}