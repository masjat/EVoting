package com.example.evoting.activity

import android.os.Bundle
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.evoting.R
import com.example.evoting.adapter.AdapterCandidates
import com.example.evoting.models.Candidate
import com.example.evoting.utils.CustomDialogUtil

class ListCandidateDelete: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_candidate_delete)

        val ivBack = findViewById<ImageView>(R.id.ivBack)
        val listView: ListView = findViewById(R.id.ls_candidate)

        val item = listOf(
            Candidate("1", R.drawable.candidate,"a","1"),
            Candidate("2", R.drawable.candidate,"a","1"),
            Candidate("3", R.drawable.candidate,"a","1"),
            Candidate("4", R.drawable.candidate,"a","1")
        )

        val adapterCandidates = AdapterCandidates(this, item)
        listView.adapter = adapterCandidates

        listView.setOnItemClickListener { _, _, position, _ ->
            val clickedItem = item[position]

            // Panggil dialog kustom
            CustomDialogUtil.showCustomDialog(
                context = this,
                message = "Yakin untuk menghapus kandidat ${clickedItem.identity}?",
                positiveButtonText = "Yes",
                positiveButtonAction = {
                    Toast.makeText(this, "${clickedItem.identity} selected!", Toast.LENGTH_SHORT).show()
                },
                negativeButtonText = "No",
                negativeButtonAction = {
                    Toast.makeText(this, "Action canceled.", Toast.LENGTH_SHORT).show()
                }
            )
        }

        ivBack.setOnClickListener {
            finish()
        }


    }
}