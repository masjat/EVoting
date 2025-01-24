package com.example.evoting.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.evoting.R

class JoinRoom : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join_room)

        val btnBack = findViewById<ImageView>(R.id.btnBack)
        val etCodeRoom = findViewById<EditText>(R.id.etCodeRoom)
        val etCodeCommittee = findViewById<EditText>(R.id.etCodeCommittee)
        val btnJoin = findViewById<Button>(R.id.btnJoin)


        btnBack.setOnClickListener {
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }
        btnJoin.setOnClickListener {
            val codeRoom = etCodeRoom.text.toString().trim()
            if (codeRoom.isEmpty()) {
                etCodeRoom.error = "Kode Ruangan tidak boleh kosong"
            } else {
                val intent = Intent(this, InputPersonalData::class.java)
                startActivity(intent)
            }
        }
    }
}