package com.example.evoting.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.evoting.R

class AddCommittee: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_committee)

        val backButton = findViewById<ImageView>(R.id.bkButton)
        val addButton = findViewById<Button>(R.id.btnAdd)
        val etNoIdentity = findViewById<EditText>(R.id.etNoIdentity)

        backButton.setOnClickListener {
            finish()
        }
        addButton.setOnClickListener {
            val noIdentity = etNoIdentity.text.toString().trim()
            if (noIdentity.isEmpty()) {
                etNoIdentity.error = "Nomor Identitas tidak boleh kosong"
                etNoIdentity.requestFocus()
            } else{
                showAddCommitteeNotification()
            }
        }
    }
    private fun showAddCommitteeNotification() {
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