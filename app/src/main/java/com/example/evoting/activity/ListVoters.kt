package com.example.evoting.activity

import android.os.Bundle
import android.widget.ImageView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.evoting.R
import com.example.evoting.adapter.AdapterIdentity
import com.example.evoting.adapter.AdapterVoters
import com.example.evoting.models.Identity
import com.example.evoting.models.Voters

class ListVoters: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_voters)

        val backButton = findViewById<ImageView>(R.id.ivBack)
        backButton.setOnClickListener {
            finish()
        }
        val listView: ListView = findViewById(R.id.ls_voter)
        val item = listOf(
            Voters("Jatmika Herlambang","2044"),
            Voters("mico kontol memek","2044"),
            Voters("sdsds","2044"),
            Voters("sdsds","2044"),
            Voters("sdsds","2044")

        )

        val adapterVoters = AdapterVoters(this, item)
        listView.adapter = adapterVoters


    }
}