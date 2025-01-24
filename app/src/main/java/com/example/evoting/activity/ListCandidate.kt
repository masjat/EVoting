package com.example.evoting.activity

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.evoting.R
import com.example.evoting.adapter.AdapterCandidates
import com.example.evoting.models.Candidate

class ListCandidate: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_candidate)

        val ivBack = findViewById<ImageView>(R.id.ivBack)
        val ivAdd = findViewById<ImageView>(R.id.ivAdd)
        val ivDelete = findViewById<ImageView>(R.id.ivDelete)
        val listView: ListView = findViewById(R.id.ls_candidate)

        val item = listOf(
            Candidate("1", R.drawable.candidate,"a","1"),
            Candidate("2", R.drawable.candidate,"a","1"),
            Candidate("3", R.drawable.candidate,"a","1"),
            Candidate("4", R.drawable.candidate,"a","1")
        )

        val adapterCandidates = AdapterCandidates(this, item)
        listView.adapter = adapterCandidates

        listView.setOnItemClickListener { parent, view, position, id ->
            when (position) {
                0 -> startActivity(Intent(this, EditCandidate::class.java))
                1 -> startActivity(Intent(this, EditCandidate::class.java))
                2 -> startActivity(Intent(this, EditCandidate::class.java))
                3 -> startActivity(Intent(this, EditCandidate::class.java))
            }
        }

        ivBack.setOnClickListener {
            finish()
        }
        ivAdd.setOnClickListener {
            val intent = Intent(this, AddCandidate::class.java)
            startActivity(intent)
        }
        ivDelete.setOnClickListener {
            val intent = Intent(this, ListCandidateDelete::class.java)
            startActivity(intent)
        }


    }
}