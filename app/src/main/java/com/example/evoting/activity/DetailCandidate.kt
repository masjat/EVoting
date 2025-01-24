package com.example.evoting.activity

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.evoting.R

class DetailCandidate : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_candidate)

        val closeView = findViewById<ImageView>(R.id.ivClose)
        closeView.setOnClickListener {
            val intent = Intent(this, DashboardRoom::class.java)
            startActivity(intent)
        }

    }
}