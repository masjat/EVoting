package com.example.evoting.activity

import android.os.Bundle
import android.widget.ImageView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.evoting.R
import com.example.evoting.adapter.AdapterCommittee
import com.example.evoting.adapter.AdapterIdentity
import com.example.evoting.models.Committee


class ListCommittee: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_committee)

        val ivBack = findViewById<ImageView>(R.id.ivBack)
        val ivAdd = findViewById<ImageView>(R.id.ivAdd)
        val ivDelete = findViewById<ImageView>(R.id.ivDelete)
        val listView: ListView = findViewById(R.id.ls_committee)

        val item = listOf(
            Committee("Jatmika","2302"),
            Committee("Jatmika","2303"),
            Committee("Jatmika","2304"),
            Committee("Jatmika","2305"),
            Committee("Jatmika","2306")
        )

        val adapterCommittee = AdapterCommittee(this, item)
        listView.adapter = adapterCommittee

        ivBack.setOnClickListener {
            finish()
        }
        ivAdd.setOnClickListener {
            val intent = android.content.Intent(this, AddCommittee::class.java)
            startActivity(intent)
        }
        ivDelete.setOnClickListener {
            val intent = android.content.Intent(this, ListCommitteeDelete::class.java)
            startActivity(intent)
        }

    }
}