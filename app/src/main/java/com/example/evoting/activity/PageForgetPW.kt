package com.example.evoting.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.evoting.R

class PageForgetPW : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)

        val etNewPassword = findViewById<EditText>(R.id.etNewPassword)
        val etRepeatPassword = findViewById<EditText>(R.id.etRePassword)
        val btnChange = findViewById<Button>(R.id.btChange)

        btnChange.setOnClickListener {
            val newPassword = etNewPassword.text.toString()
            val repeatPassword = etRepeatPassword.text.toString()

            when {
                newPassword.isEmpty() || repeatPassword.isEmpty() -> {
                    Toast.makeText(this, "Kata sandi tidak boleh kosong", Toast.LENGTH_SHORT).show()
                }
                newPassword != repeatPassword -> {
                    Toast.makeText(this, "Kata sandi tidak cocok", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Toast.makeText(this, "Kata sandi berhasil diubah", Toast.LENGTH_SHORT).show()
                    // Tambahkan logika untuk mengubah kata sandi di sini
                }
            }
        }
    }
}
