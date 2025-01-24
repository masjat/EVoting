package com.example.evoting.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.evoting.R

class EditCandidate : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_candidate)

        val backButton = findViewById<ImageView>(R.id.bkButton)
        val nameCandidate = findViewById<EditText>(R.id.etNmCandidate)
        val idMember = findViewById<EditText>(R.id.etIdMember)
        val noSerial = findViewById<EditText>(R.id.etNoSerial)
        val vision = findViewById<EditText>(R.id.etVision)
        val mission = findViewById<EditText>(R.id.etMission)
        val ftCandidate = findViewById<Button>(R.id.btFtCandidate)
        val changeButton = findViewById<Button>(R.id.btnChange)

        backButton.setOnClickListener {
            finish()
        }

        ftCandidate.setOnClickListener {

        }

        changeButton.setOnClickListener {
            showAddIdentityNotification()
        }

    }
    private fun showAddIdentityNotification() {
        val inflater = layoutInflater
        val layout = inflater.inflate(R.layout.toast_costum, null)


        val toastText = layout.findViewById<TextView>(R.id.toast_text)
        toastText.text = "Perubahan berhasil disimpan"


        val toast = Toast(applicationContext)
        toast.duration = Toast.LENGTH_LONG
        toast.view = layout
        toast.show()
    }
}