package com.example.evoting.activity

import android.os.Bundle
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.evoting.R
import com.example.evoting.adapter.AdapterIdentity
import com.example.evoting.models.Identity
import com.example.evoting.utils.CustomDialogUtil

class ListIdentityDelete: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_identity_delete)

        val ivBack = findViewById<ImageView>(R.id.ivBack)
        val ivSearch = findViewById<ImageView>(R.id.ivSearch)
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

        listView.setOnItemClickListener { _, _, position, _ ->
            val clickedItem = item[position]

            // Panggil dialog kustom
            CustomDialogUtil.showCustomDialog(
                context = this,
                message = "Do you want to select ${clickedItem.identity}?",
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
            val intent = android.content.Intent(this, SearchIdentityDelete::class.java)
            startActivity(intent)
        }

    }
}