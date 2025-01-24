package com.example.evoting.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.example.evoting.R

class Menus : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menus)

        // Inisialisasi V
        val btnclose = findViewById<Button>(R.id.btnclose)
        val txDashboard = findViewById<TextView>(R.id.tx_dashboard)
        val txProfil = findViewById<TextView>(R.id.tx_profil)
        val txSetting = findViewById<TextView>(R.id.tx_setting)
        val llLogout = findViewById<LinearLayout>(R.id.ll_logout)

        // Tombol "Close" untuk kembali ke halaman sebelumnya
        btnclose.setOnClickListener {
            finish() // Mengakhiri activity saat ini
        }

        // Navigasi ke "Beranda"
        txDashboard.setOnClickListener {
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }

        // Navigasi ke "Profil"
        txProfil.setOnClickListener {
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }

        // Navigasi ke "Pengaturan"
        txSetting.setOnClickListener {
            val intent = Intent(this, MenuSetting::class.java)
            startActivity(intent)
        }

        // Navigasi ke "Landing Page" (Logout)
        llLogout.setOnClickListener {
            val intent = Intent(this, LandingPage::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}