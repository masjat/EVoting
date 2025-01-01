package com.example.evoting.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.evoting.R
import com.example.evoting.network.AuthManager
import com.example.evoting.utils.ValidationUtils
import kotlinx.coroutines.launch

class InputEmail : AppCompatActivity() {

    private val authManager = AuthManager()  // Inisialisasi AuthManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_email)

        val emailEditText = findViewById<EditText>(R.id.etEmail)
        val continueButton = findViewById<Button>(R.id.btNext)

        continueButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()

            if (!ValidationUtils.isEmailValid(email)) {
                emailEditText.error = "Format email tidak valid"
                emailEditText.requestFocus()
            } else {
                lifecycleScope.launch {
                    try {
                        val response = authManager.sendOtp(email)
                        if (response.isSuccessful) {
                            Toast.makeText(this@InputEmail, "Kode berhasil dikirim", Toast.LENGTH_SHORT).show()

                            val intent = Intent(this@InputEmail, PageOtp::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this@InputEmail, "Gagal mengirim OTP", Toast.LENGTH_SHORT).show()
                        }
                    } catch (e: Exception) {
                        Toast.makeText(this@InputEmail, "Terjadi kesalahan: ${e.message}", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}
