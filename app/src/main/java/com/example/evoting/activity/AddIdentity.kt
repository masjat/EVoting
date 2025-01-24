package com.example.evoting.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.evoting.R
import com.example.evoting.utils.ValidationUtils

class AddIdentity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_identity)

        val btnNext = findViewById<Button>(R.id.btNext)
        val btnPlus = findViewById<Button>(R.id.btPlus)
        val etNoIdentity = findViewById<EditText>(R.id.etNoIdentity)

        btnNext.setOnClickListener {
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }
        btnPlus.setOnClickListener {
            val noIdentity = etNoIdentity.text.toString().trim()

            if (!ValidationUtils.noIdentityValid(noIdentity)) {
                etNoIdentity.error = "Nomor Identitas tidak boleh kosong"
                etNoIdentity.requestFocus()
            } else {
                showAddIdentityNotification()
            }
        }
    }

    private fun showAddIdentityNotification() {
        val inflater = layoutInflater
        val layout = inflater.inflate(R.layout.toast_costum, null)


        val toastText = layout.findViewById<TextView>(R.id.toast_text)
        toastText.text = "No identitas berhasil ditambahkan"


        val toast = Toast(applicationContext)
        toast.duration = Toast.LENGTH_LONG
        toast.view = layout
        toast.show()
    }
}