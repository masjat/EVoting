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
            val intent = Intent(this, Login::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP // Menambahkan flag ini
            startActivity(intent)
            finish()
        }

        // Button Register
        val buttonRegister: Button = findViewById(R.id.btRegister)
        buttonRegister.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP // Menambahkan flag ini
            startActivity(intent)
            finish()


        }
    }
}