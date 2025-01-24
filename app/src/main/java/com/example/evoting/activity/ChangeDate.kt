package com.example.evoting.activity

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.evoting.R
import java.util.Calendar

class ChangeDate: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_date)

        val backButton = findViewById<ImageView>(R.id.bkButton)
        val changeCalendar = findViewById<EditText>(R.id.etCalendar)
        val changeButton = findViewById<TextView>(R.id.btnChange)

        backButton.setOnClickListener {
            val intent = Intent(this, RoomSetting::class.java)
            startActivity(intent)
        }

        changeButton.setOnClickListener {
            val calendar = changeCalendar.text.toString().trim()
            if (calendar.isEmpty()) {
                    changeCalendar.error = "Tanggal tidak boleh kosong"
            } else {
                showChangedNotification()
            }
        }
        changeCalendar.setOnClickListener {
            showDatePickerDialog(changeCalendar)
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
    private fun showChangedNotification() {
        val inflater = layoutInflater
        val layout = inflater.inflate(R.layout.toast_costum, null)


        val toastText = layout.findViewById<TextView>(R.id.toast_text)
        toastText.text = "Tanggal berhasil diubah"


        val toast = Toast(applicationContext)
        toast.duration = Toast.LENGTH_LONG
        toast.view = layout
        toast.show()



    }
}