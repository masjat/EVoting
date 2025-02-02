package com.example.evoting.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.MotionEvent
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.evoting.R
import com.example.evoting.network.AuthManager
import com.example.evoting.utils.PasswordUtils
import com.example.evoting.utils.ValidationUtils

class Login : AppCompatActivity() {

    private var isPasswordVisible = false
    private val authManager = AuthManager()
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Inisialisasi SharedPreferences
        sharedPreferences = getSharedPreferences("UserPreferences", Context.MODE_PRIVATE)

        val editEmail: EditText = findViewById(R.id.etEmail)
        val editPassword: EditText = findViewById(R.id.etPassword)
        val textForgotPassword: TextView = findViewById(R.id.txForgetPassword)
        val buttonLogin: Button = findViewById(R.id.btLogin)
        val textRegister: TextView = findViewById(R.id.txRegister)

        // Reset status isPasswordVisible setiap kali halaman login terbuka
        resetPasswordVisibility()

        isPasswordVisible = sharedPreferences.getBoolean("isPasswordVisible", false)
        updatePasswordVisibility(editPassword)

        editPassword.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                val drawableEnd = editPassword.compoundDrawablesRelative[2]
                if (drawableEnd != null && event.rawX >= (editPassword.right - drawableEnd.bounds.width() - editPassword.paddingEnd)) {
                    isPasswordVisible = PasswordUtils.togglePasswordVisibility(editPassword, isPasswordVisible)
                    // Simpan status visibility ke SharedPreferences
                    val editor = sharedPreferences.edit()
                    editor.putBoolean("isPasswordVisible", isPasswordVisible)
                    editor.apply()

                    // Update ikon berdasarkan status visibility
                    updatePasswordVisibility(editPassword)
                    true
                } else false
            } else false
        }

        textForgotPassword.setOnClickListener {
            val intent = Intent(this, InputEmail::class.java)
            startActivity(intent)
        }

        buttonLogin.setOnClickListener {
            val email = editEmail.text.toString().trim()
            val password = editPassword.text.toString().trim()


            // Validasi
            if (!ValidationUtils.isEmailValid(email)) {
                editEmail.error = "Format email tidak valid"
                editEmail.requestFocus()
            } else if (!ValidationUtils.isPasswordValid(password)) {
                editPassword.error = "Kata sandi minimal 6 karakter"
                editPassword.requestFocus()
            } else {
                val intent = Intent(this, Dashboard::class.java)
                startActivity(intent)
                finish()
            }
       }

        textRegister.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP // Menambahkan flag ini
            startActivity(intent)
            finish()

        }
    }

    // Fungsi untuk memperbarui status visibility password
    private fun updatePasswordVisibility(editPassword: EditText) {
        val drawable = if (isPasswordVisible) R.drawable.baseline_visibility_24 else R.drawable.baseline_visibility_off_24
        editPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, drawable, 0)
    }

    // Reset status visibility password saat halaman login dimulai
    private fun resetPasswordVisibility() {
        val editor = sharedPreferences.edit()
        editor.putBoolean("isPasswordVisible", false) // Set ke default false saat login
        editor.apply()
    }

}
