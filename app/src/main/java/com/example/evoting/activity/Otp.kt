package com.example.evoting.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.evoting.R
import com.example.evoting.network.AuthManager

class Otp : AppCompatActivity() {

    private val authManager = AuthManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_otp)

        val email = intent.getStringExtra("email") ?: ""
        val editTextOtp: EditText = findViewById(R.id.etOtp)
        val resendText: TextView = findViewById(R.id.rsOtp)
        val buttonNext: Button = findViewById(R.id.btNext)

        val source = intent.getStringExtra("SOURCE")


        // Kirim ulang OTP jika diperlukan
        resendText.setOnClickListener {
            showResendOtpNotification()
        }

        // Verifikasi OTP
        buttonNext.setOnClickListener {
            val otp = editTextOtp.text.toString().trim()
            if (otp.isEmpty()) {
                showSendOtpNotification()
            } else {
                when (source) {
                    "REGISTER" -> {
                        // Navigasi dari sesi register
                        startActivity(Intent(this, Dashboard::class.java))
                        finish()
                    }

                    "FORGOT_PASSWORD" -> {
                        // Navigasi dari sesi ganti password
                        startActivity(Intent(this, ChangePasswordWithOtp::class.java))
                        finish() // Opsional, agar pengguna tidak bisa kembali ke dashboard dengan tombol back
                    }

                    else -> {
                        // Default behavior jika tidak ada sumber
                        Toast.makeText(this, "Sumber tidak diketahui", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun showResendOtpNotification() {
        val inflater = layoutInflater
        val layout = inflater.inflate(R.layout.toast_costum, null)


        val toastText = layout.findViewById<TextView>(R.id.toast_text)
        toastText.text = "Kode otp berhasil dikirim"


        val toast = Toast(applicationContext)
        toast.duration = Toast.LENGTH_LONG
        toast.view = layout
        toast.show()
    }

    private fun showSendOtpNotification() {
        val inflater = layoutInflater
        val layout = inflater.inflate(R.layout.toast_costum, null)


        val toastText = layout.findViewById<TextView>(R.id.toast_text)
        toastText.text = "Masukkan kode OTP terlebih dahulu"


        val toast = Toast(applicationContext)
        toast.duration = Toast.LENGTH_LONG
        toast.view = layout
        toast.show()
    }
}
