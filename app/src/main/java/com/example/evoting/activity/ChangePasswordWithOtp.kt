package com.example.evoting.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.MotionEvent
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.evoting.R
import com.example.evoting.utils.PasswordUtils
import com.example.evoting.utils.ValidationUtils

class ChangePasswordWithOtp : AppCompatActivity() {

    private var isPasswordVisible = false
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password_with_otp)

        sharedPreferences = getSharedPreferences("UserPreferences", Context.MODE_PRIVATE)


        val etNewPassword = findViewById<EditText>(R.id.etNewPassword)
        val etRepeatPassword = findViewById<EditText>(R.id.etRePassword)
        val btnChange = findViewById<Button>(R.id.btChange)

        resetPasswordVisibility()

        isPasswordVisible = sharedPreferences.getBoolean("isPasswordVisible", false)
        updatePasswordVisibility(etNewPassword)
        updatePasswordVisibility(etRepeatPassword)

        etNewPassword.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                val drawableEnd = etNewPassword.compoundDrawablesRelative[2]
                if (drawableEnd != null && event.rawX >= (etNewPassword.right - drawableEnd.bounds.width() - etNewPassword.paddingEnd)) {
                    isPasswordVisible = PasswordUtils.togglePasswordVisibility(etNewPassword, isPasswordVisible)

                    val editor = sharedPreferences.edit()
                    editor.putBoolean("isPasswordVisible", isPasswordVisible)
                    editor.apply()

                    val drawable = if (isPasswordVisible) R.drawable.baseline_visibility_24 else R.drawable.baseline_visibility_off_24
                    etNewPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, drawable, 0)
                    true
                } else false
            } else false
        }

        etRepeatPassword.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                val drawableEnd = etRepeatPassword.compoundDrawablesRelative[2]
                if (drawableEnd != null && event.rawX >= (etRepeatPassword.right - drawableEnd.bounds.width() - etRepeatPassword.paddingEnd)) {
                    isPasswordVisible = PasswordUtils.togglePasswordVisibility(etRepeatPassword, isPasswordVisible)

                    val editor = sharedPreferences.edit()
                    editor.putBoolean("isPasswordVisible", isPasswordVisible)
                    editor.apply()

                    val drawable = if (isPasswordVisible) R.drawable.baseline_visibility_24 else R.drawable.baseline_visibility_off_24
                    etRepeatPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, drawable, 0)
                    true
                } else false
            } else false
        }


        btnChange.setOnClickListener {
            val newPassword = etNewPassword.text.toString().trim()
            val repeatPassword = etRepeatPassword.text.toString().trim()

            // Validasi
            if (!ValidationUtils.isPasswordValid(newPassword)) {
                etNewPassword.error = "Kata sandi minimal 6 karakter"
                etNewPassword.requestFocus()
            } else if (!ValidationUtils.isPasswordValid(repeatPassword)) {
                etRepeatPassword.error = "Kata sandi dan kata sandi ulang tidak sama"
                etRepeatPassword.requestFocus()
            } else {
                showPasswordChangedNotification()
            }
        }
    }

    private fun showPasswordChangedNotification() {
        val inflater = layoutInflater
        val layout = inflater.inflate(R.layout.toast_costum, null)


        val toastText = layout.findViewById<TextView>(R.id.toast_text)
        toastText.text = "Kata sandi berhasil diubah"


        val toast = Toast(applicationContext)
        toast.duration = Toast.LENGTH_LONG
        toast.view = layout
        toast.show()


        // Aksi setelah menampilkan Toast, mengarahkan pengguna ke halaman login
        val intent = Intent(this, Login::class.java)
        startActivity(intent)
        finish()  // Menutup halaman reset password
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
