package com.example.evoting.activity

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.evoting.R
import java.util.Calendar

class CreateRoom : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_room)

        val ivBack = findViewById<ImageView>(R.id.ivBack)
        val etNameRoom = findViewById<EditText>(R.id.etNameRoom)
        val etCalendar = findViewById<EditText>(R.id.etCalendar)
        val btnCreate = findViewById<Button>(R.id.btnCreate)

        ivBack.setOnClickListener {
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }
        btnCreate.setOnClickListener {
            val nameRoom = etNameRoom.text.toString().trim()
            val calendar = etCalendar.text.toString().trim()
            if (nameRoom.isEmpty()) {
                etNameRoom.error = "Nama Ruangan tidak boleh kosong"
            } else if (calendar.isEmpty()) {
                etCalendar.error = "Tanggal tidak boleh kosong"
            } else {
                val intent = Intent(this, NotificationCreateRoom::class.java)
                startActivity(intent)
            }
        }
        etCalendar.setOnClickListener {
            showDatePickerDialog(etCalendar)
        }

    }
    private fun showDatePickerDialog(editText: EditText) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { _, selectedYear, selectedMonth, selectedDay ->
                // Set selected date in the EditText
                val formattedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                editText.setText(formattedDate)
            },
            year, month, day
        )
        datePickerDialog.show()
    }
}