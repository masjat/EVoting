package com.example.evoting.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.MotionEvent
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.evoting.R
import com.example.evoting.utils.PasswordUtils

class ChangePassword :AppCompatActivity() {

    private var isPasswordVisible = false
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)
        sharedPreferences = getSharedPreferences("UserPreferences", Context.MODE_PRIVATE)
        resetPasswordVisibility()

        val etOldPassword = findViewById<EditText>(R.id.etOldPassword)
        val etNewPassword = findViewById<EditText>(R.id.etNewPassword)
        val etRepeatPassword = findViewById<EditText>(R.id.etRePassword)
        val btnChange = findViewById<Button>(R.id.btnChange)
        val backButton = findViewById<ImageView>(R.id.back_button)

        isPasswordVisible = sharedPreferences.getBoolean("isPasswordVisible", false)
        updatePasswordVisibility(etOldPassword)
        updatePasswordVisibility(etNewPassword)
        updatePasswordVisibility(etRepeatPassword)

        etOldPassword.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                val drawableEnd = etOldPassword.compoundDrawablesRelative[2]
                if (drawableEnd != null && event.rawX >= (etOldPassword.right - drawableEnd.bounds.width() - etOldPassword.paddingEnd)) {
                    isPasswordVisible =
                        PasswordUtils.togglePasswordVisibility(etOldPassword, isPasswordVisible)
                    val editor = sharedPreferences.edit()
                    editor.putBoolean("isPasswordVisible", isPasswordVisible)
                    editor.apply()
                    updatePasswordVisibility(etOldPassword)
                    true
                } else false
            } else false
        }


        etNewPassword.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                val drawableEnd = etNewPassword.compoundDrawablesRelative[2]
                if (drawableEnd != null && event.rawX >= (etNewPassword.right - drawableEnd.bounds.width() - etNewPassword.paddingEnd)) {
                    isPasswordVisible =
                        PasswordUtils.togglePasswordVisibility(etNewPassword, isPasswordVisible)
                    val editor = sharedPreferences.edit()
                    editor.putBoolean("isPasswordVisible", isPasswordVisible)
                    editor.apply()
                    updatePasswordVisibility(etNewPassword)
                    true
                } else false
            } else false
        }

        etRepeatPassword.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                val drawableEnd = etRepeatPassword.compoundDrawablesRelative[2]
                if (drawableEnd != null && event.rawX >= (etRepeatPassword.right - drawableEnd.bounds.width() - etRepeatPassword.paddingEnd)) {
                    isPasswordVisible =
                        PasswordUtils.togglePasswordVisibility(etRepeatPassword, isPasswordVisible)
                    val editor = sharedPreferences.edit()
                    editor.putBoolean("isPasswordVisible", isPasswordVisible)
                    editor.apply()
                    updatePasswordVisibility(etRepeatPassword)
                    true
                } else false
            } else false
        }
        backButton.setOnClickListener {
            finish()
        }
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
                    // Menampilkan Toast untuk menunjukkan password berhasil diubah
                    showPasswordChangedNotification()
                }
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
        val intent = Intent(this, MenuSetting::class.java)
        startActivity(intent)
        finish()  // Menutup halaman reset password
    }

    private fun updatePasswordVisibility(editPassword: EditText) {
        val drawable = if (isPasswordVisible) R.drawable.baseline_visibility_24 else R.drawable.baseline_visibility_off_24
        editPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, drawable, 0)
    }
    private fun resetPasswordVisibility() {
        val editor = sharedPreferences.edit()
        editor.putBoolean("isPasswordVisible", false) // Set ke default false saat login
        editor.apply()
    }
}
