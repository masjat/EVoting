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

class Register : AppCompatActivity() {

    private var isPasswordVisible = false
    private val authManager = AuthManager()
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        sharedPreferences = getSharedPreferences("UserPreferences", Context.MODE_PRIVATE)

        val editFullName: EditText = findViewById(R.id.etUsername)
        val editEmail: EditText = findViewById(R.id.etEmail)
        val editPassword: EditText = findViewById(R.id.etPassword)
        val editPasswordConfirm: EditText = findViewById(R.id.etPasswordConfirm)
        val buttonRegister: Button = findViewById(R.id.btRegister)
        val textLogin : TextView = findViewById(R.id.txLogin)

        // Reset status visibility password saat halaman registrasi dimulai
        resetPasswordVisibility()

        // Mengambil status visibility dari SharedPreferences
        isPasswordVisible = sharedPreferences.getBoolean("isPasswordVisible", false)
        updatePasswordVisibility(editPassword)
        updatePasswordVisibility(editPasswordConfirm)  // Update visibilitas untuk kedua password

        // Handle visibility password pada input password
        editPassword.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                val drawableEnd = editPassword.compoundDrawablesRelative[2]
                if (drawableEnd != null && event.rawX >= (editPassword.right - drawableEnd.bounds.width() - editPassword.paddingEnd)) {
                    isPasswordVisible = PasswordUtils.togglePasswordVisibility(editPassword, isPasswordVisible)

                    val editor = sharedPreferences.edit()
                    editor.putBoolean("isPasswordVisible", isPasswordVisible)
                    editor.apply()

                    val drawable = if (isPasswordVisible) R.drawable.baseline_visibility_24 else R.drawable.baseline_visibility_off_24
                    editPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, drawable, 0)
                    true
                } else false
            } else false
        }

        // Handle visibility password pada input password confirm
        editPasswordConfirm.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                val drawableEnd = editPasswordConfirm.compoundDrawablesRelative[2]
                if (drawableEnd != null && event.rawX >= (editPasswordConfirm.right - drawableEnd.bounds.width() - editPasswordConfirm.paddingEnd)) {
                    isPasswordVisible = PasswordUtils.togglePasswordVisibility(editPasswordConfirm, isPasswordVisible)

                    val editor = sharedPreferences.edit()
                    editor.putBoolean("isPasswordVisible", isPasswordVisible)
                    editor.apply()

                    val drawable = if (isPasswordVisible) R.drawable.baseline_visibility_24 else R.drawable.baseline_visibility_off_24
                    editPasswordConfirm.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, drawable, 0)
                    true
                } else false
            } else false
        }

        buttonRegister.setOnClickListener {
            val fullName = editFullName.text.toString().trim()
            val email = editEmail.text.toString().trim()
            val password = editPassword.text.toString().trim()
            val confirmPassword = editPasswordConfirm.text.toString().trim()


            // Validasi
            if (!ValidationUtils.isFullNameValid(fullName)) {
                editFullName.error = "Nama lengkap harus diisi"
                editFullName.requestFocus()
            } else if (!ValidationUtils.isEmailValid(email)) {
                editEmail.error = "Format email tidak valid"
                editEmail.requestFocus()
            } else if (!ValidationUtils.isPasswordValid(password)) {
                editPassword.error = "Kata sandi minimal 6 karakter"
                editPassword.requestFocus()
            } else if (!ValidationUtils.doPasswordsMatch(password, confirmPassword)) {
                editPasswordConfirm.error = "Kata sandi dan kata sandi ulang tidak sama"
                editPasswordConfirm.requestFocus()
            } else {
                val intent = Intent(this, Otp::class.java)
                intent.putExtra("SOURCE", "REGISTER")
                startActivity(intent)
                finish()
            }
        }

        textLogin.setOnClickListener {
            val intent = Intent(this, Login::class.java)
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

    // Reset status visibility password saat halaman registrasi dimulai
    private fun resetPasswordVisibility() {
        val editor = sharedPreferences.edit()
        editor.putBoolean("isPasswordVisible", false) // Set ke default false saat registrasi
        editor.apply()
    }
}
