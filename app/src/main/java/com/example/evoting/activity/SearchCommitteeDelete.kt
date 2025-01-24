package com.example.evoting.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.evoting.R
import com.example.evoting.utils.CustomDialogUtil

class SearchCommitteeDelete: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_committee_delete)

        val backButton = findViewById<ImageView>(R.id.bkButton)
        val deleteButton = findViewById<Button>(R.id.btnDelete)
        val etNoIdentity = findViewById<EditText>(R.id.etNoIdentity)

        backButton.setOnClickListener {
            finish()
        }
        deleteButton.setOnClickListener {
            val noIdentity = etNoIdentity.text.toString().trim()
            if (noIdentity.isEmpty()) {
                etNoIdentity.error = "Nomor Identitas tidak boleh kosong"
                etNoIdentity.requestFocus()
            } else{
                CustomDialogUtil.showCustomDialog(
                    context = this,
                    message = "Are you sure you want to delete this item?",
                    positiveButtonText = "Yes",
                    positiveButtonAction = {
                        // Aksi jika tombol Yes diklik
                        Toast.makeText(this, "Item deleted", Toast.LENGTH_SHORT).show()
                    },
                    negativeButtonText = "No",
                    negativeButtonAction = {
                        // Aksi jika tombol No diklik
                        Toast.makeText(this, "Delete canceled", Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }
    }
}