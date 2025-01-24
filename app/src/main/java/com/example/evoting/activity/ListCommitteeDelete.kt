package com.example.evoting.activity

import android.os.Bundle
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.evoting.R
import com.example.evoting.adapter.AdapterCommittee
import com.example.evoting.models.Committee
import com.example.evoting.utils.CustomDialogUtil

class ListCommitteeDelete: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_committee_delete)

        val ivBack = findViewById<ImageView>(R.id.ivBack)
        val ivSearch = findViewById<ImageView>(R.id.ivSearch)
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

        listView.setOnItemClickListener { _, _, position, _ ->
            val clickedItem = item[position]

            // Panggil dialog kustom
            CustomDialogUtil.showCustomDialog(
                context = this,
                message = "Ingin menghapus panitia ${clickedItem.identity}?",
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

        ivSearch.setOnClickListener {
            val intent = android.content.Intent(this, SearchCommitteeDelete::class.java)
            startActivity(intent)
        }

    }
}