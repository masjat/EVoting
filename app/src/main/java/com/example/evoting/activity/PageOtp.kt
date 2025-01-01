package com.example.evoting.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.evoting.R
import com.example.evoting.network.AuthManager
import kotlinx.coroutines.launch

class PageOtp : AppCompatActivity() {

    private val authManager = AuthManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_otp)

        val email = intent.getStringExtra("email") ?: ""
        val editTextOtp: EditText = findViewById(R.id.etOtp)
        val resendText: TextView = findViewById(R.id.rsOtp)
        val buttonNext: Button = findViewById(R.id.btNext)

        // Kirim ulang OTP jika diperlukan
        resendText.setOnClickListener {
            if (email.isNotEmpty()) {
                resendOtp(email)
            }
        }

        // Verifikasi OTP
        buttonNext.setOnClickListener {
            val otp = editTextOtp.text.toString().trim()
            if (otp.isEmpty()) {
                Toast.makeText(this, "Masukkan kode OTP terlebih dahulu", Toast.LENGTH_SHORT).show()
            } else {
                verifyOtp(email, otp)
            }
        }
    }

    private fun resendOtp(email: String) {
        lifecycleScope.launch {
            try {
                val response = authManager.sendOtp(email)
                if (response.isSuccessful) {
                    Toast.makeText(this@PageOtp, "OTP dikirim ulang!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@PageOtp, "Gagal mengirim ulang OTP", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Toast.makeText(this@PageOtp, "Terjadi kesalahan: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun verifyOtp(email: String, otp: String) {
        lifecycleScope.launch {
            try {
                val response = authManager.verifyOtp(email, otp)
                if (response.isSuccessful) {
                    Toast.makeText(this@PageOtp, "OTP berhasil diverifikasi", Toast.LENGTH_SHORT).show()
                    // Lanjutkan ke halaman reset password atau langkah selanjutnya
                    // val intent = Intent(this@PageOtpActivity, ResetPasswordActivity::class.java)
                    // startActivity(intent)
                } else {
                    Toast.makeText(this@PageOtp, "OTP tidak valid", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Toast.makeText(this@PageOtp, "Terjadi kesalahan: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
