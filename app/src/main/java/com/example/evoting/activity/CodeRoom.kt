package com.example.evoting.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.evoting.R

class CodeRoom:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code_room)

        val backButton = findViewById<ImageView>(R.id.bkButton)
        val copyButton = findViewById<Button>(R.id.btnCopy)

        backButton.setOnClickListener {
            val intent = Intent(this, RoomSetting::class.java)
            startActivity(intent)
        }

        copyButton.setOnClickListener {
            Toast.makeText(this, "kode berhasil disalin", Toast.LENGTH_SHORT).show()
        }
    }
}