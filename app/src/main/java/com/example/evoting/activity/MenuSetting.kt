package com.example.evoting.activity

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.evoting.R

class MenuSetting : AppCompatActivity() {
    private lateinit var backButton: ImageView
    private lateinit var tvTheme: TextView
    private lateinit var tvPassword: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting_menu)

        backButton = findViewById(R.id.back_button)
        tvTheme = findViewById(R.id.tv_theme)
        tvPassword = findViewById(R.id.tv_password)

        // Event untuk tombol kembali
        backButton.setOnClickListener {
            // Tutup aktivitas ini dan kembali ke aktivitas sebelumnya
            finish()
        }

        // Event untuk "Ganti Tema"
        tvTheme.setOnClickListener {
            // Panggil fungsi untuk mengubah tema
        }

        // Event untuk "Ganti Kata Sandi"
        tvPassword.setOnClickListener {
            // Navigasi ke halaman ganti kata sandi
            val intent = Intent(this, ChangePassword::class.java)
            startActivity(intent)
        }
    }

}
