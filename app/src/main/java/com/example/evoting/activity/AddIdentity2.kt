package com.example.evoting.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.evoting.R
import com.example.evoting.utils.ValidationUtils

class AddIdentity2: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_identity2)

        val backButton = findViewById<ImageView>(R.id.bkButton)
        val editIdentity = findViewById<EditText>(R.id.etNoIdentity)
        val addButton = findViewById<Button>(R.id.btnAdd)

        backButton.setOnClickListener {
            finish()
        }
        addButton.setOnClickListener {
            val noIdentity = editIdentity.text.toString().trim()
            if (!ValidationUtils.noIdentityValid(noIdentity)) {
                editIdentity.error = "Nomor Identitas tidak boleh kosong"
                editIdentity.requestFocus()
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