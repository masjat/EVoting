package com.example.evoting.activity

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.evoting.R
import com.example.evoting.utils.CustomDialogUtil

class RoomSetting : AppCompatActivity () {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting_room)

        val backButton = findViewById<ImageView>(R.id.back_button)
        val changeDate = findViewById<TextView>(R.id.change_date)
        val listIdentity = findViewById<TextView>(R.id.list_identity)
        val listVoter = findViewById<TextView>(R.id.list_voter)
        val listCandidate = findViewById<TextView>(R.id.list_candidate)
        val listCommittee = findViewById<TextView>(R.id.list_committee)
        val cdRoomVoter = findViewById<TextView>(R.id.cd_room_voter)
        val cdCommittee = findViewById<TextView>(R.id.cd_committee)
        val statistic = findViewById<TextView>(R.id.statistic)
        val dtRoom = findViewById<TextView>(R.id.dt_room)

        backButton.setOnClickListener {
            val intent = Intent(this, DashboardRoom::class.java)
            startActivity(intent)
        }
        changeDate.setOnClickListener {
            val intent = Intent(this, ChangeDate::class.java)
            startActivity(intent)
        }
        cdRoomVoter.setOnClickListener {
            val intent = Intent(this, CodeRoom::class.java)
            startActivity(intent)
        }
        cdCommittee.setOnClickListener {
            val intent = Intent(this, CodeAccess::class.java)
            startActivity(intent)
        }
        listIdentity.setOnClickListener {
            val intent = Intent(this, ListIdentity::class.java)
            startActivity(intent)
        }
        listVoter.setOnClickListener {
            val intent = Intent(this, ListVoters::class.java)
            startActivity(intent)
        }
        listCandidate.setOnClickListener {
            val intent = Intent(this, ListCandidate::class.java)
            startActivity(intent)
        }
        listCommittee.setOnClickListener {
            val intent = Intent(this, ListCommittee::class.java)
            startActivity(intent)
        }
        statistic.setOnClickListener {
            val intent = Intent(this, Statistics::class.java)
            startActivity(intent)

        }
        dtRoom.setOnClickListener {
            CustomDialogUtil.showCustomDialog(
                context = this,
                message = "Apakah anda yakin untuk menghapus ruang?",
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