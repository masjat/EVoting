package com.example.evoting.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.evoting.R

class NotificationCreateRoom : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notification_create_room)

        val btnNext = findViewById<Button>(R.id.btNext)
        val btnPlus = findViewById<Button>(R.id.btPlus)

        btnNext.setOnClickListener {
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }
        btnPlus.setOnClickListener {
            val intent = Intent(this, AddIdentity::class.java)
            startActivity(intent)
        }
    }
}