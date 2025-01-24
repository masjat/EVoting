package com.example.evoting.activity

import android.os.Bundle
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.evoting.R
import com.example.evoting.adapter.AdapterIdentity
import com.example.evoting.models.Identity

class ListIdentity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_identity)

        val ivBack = findViewById<ImageView>(R.id.ivBack)
        val ivAdd = findViewById<ImageView>(R.id.ivAdd)
        val ivDelete = findViewById<ImageView>(R.id.ivDelete)
        val listView: ListView = findViewById(R.id.ls_identity)

        val item = listOf(
            Identity("2302"),
            Identity("2303"),
            Identity("2304"),
            Identity("2305"),
            Identity("2306")
        )

        val adapterIdentity = AdapterIdentity(this, item)
        listView.adapter = adapterIdentity


        ivBack.setOnClickListener {
            finish()
        }

        ivAdd.setOnClickListener {
            val intent = android.content.Intent(this, AddIdentity2::class.java)
            startActivity(intent)
        }

        ivDelete.setOnClickListener {
           val intent = android.content.Intent(this, ListIdentityDelete::class.java)
            startActivity(intent)
        }

    }
}