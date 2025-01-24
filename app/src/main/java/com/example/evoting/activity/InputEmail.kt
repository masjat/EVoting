package com.example.evoting.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.evoting.R
import com.example.evoting.network.AuthManager
import com.example.evoting.utils.ValidationUtils

class InputEmail : AppCompatActivity() {

    private val authManager = AuthManager()  // Inisialisasi AuthManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_email)

        val emailEditText = findViewById<EditText>(R.id.etEmail)
        val continueButton = findViewById<Button>(R.id.btNext)

        continueButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()

            if (email.isEmpty()) {
                emailEditText.error = "Email harus diisi"
                emailEditText.requestFocus()
            } else if
                (!ValidationUtils.isEmailValid(email)) {
                    emailEditText.error = "Format email tidak valid"
                    emailEditText.requestFocus()
            } else {
                    val intent = Intent(this, Otp::class.java)
                    intent.putExtra("SOURCE", "FORGOT_PASSWORD") // Beri tahu bahwa berasal dari Input Email (Lupa Password)
                    startActivity(intent)
                }
                }
    }

}


