package com.example.evoting.activity

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.evoting.R
import java.util.Calendar

class InputPersonalData : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_personal_data)

        val etBornDate: EditText = findViewById(R.id.etBornDate)
        val spinnerGender: Spinner = findViewById(R.id.etGender)  // Menggunakan Spinner untuk jenis kelamin
        val btnNext: Button = findViewById(R.id.btnNext)

        // Handle date picker for Born Date
        etBornDate.setOnClickListener {
            showDatePickerDialog(etBornDate)
        }

        // Set data untuk Spinner Gender
        val genderOptions = arrayOf("Pilih Jenis Kelamin", "Laki-Laki", "Perempuan") // Menambahkan item hint pertama
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, genderOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerGender.adapter = adapter

        // Set selection ke item pertama sebagai hint (Pilih Jenis Kelamin)
        spinnerGender.setSelection(0)

        // Handle change button (example: Save changes)
        btnNext.setOnClickListener {
            saveProfileData()
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
    private fun saveProfileData() {
        val etFullName: EditText = findViewById(R.id.etFullName)
        val etNoIdentity: EditText = findViewById(R.id.etNoIdentity)
        val etBornPlace: EditText = findViewById(R.id.etBornPlace)
        val etBornDate: EditText = findViewById(R.id.etBornDate)
        val spinnerGender: Spinner = findViewById(R.id.etGender) // Menggunakan Spinner untuk jenis kelamin

        // Get data from EditTexts and Spinner
        val fullname = etFullName.text.toString()
        val identity = etNoIdentity.text.toString()
        val bornPlace = etBornPlace.text.toString()
        val bornDate = etBornDate.text.toString()
        val gender = spinnerGender.selectedItem.toString()  // Mengambil nilai yang dipilih di Spinner

        // Example validation
        if (fullname.isEmpty() || identity.isEmpty() || bornPlace.isEmpty() || bornDate.isEmpty() || gender == "Pilih Jenis Kelamin") {
            Toast.makeText(this, "Semua data harus diisi!", Toast.LENGTH_SHORT).show()
        } else {
            // Perform save action (e.g., send to server or save locally)
            Toast.makeText(this, "Data berhasil disimpan!", Toast.LENGTH_SHORT).show()
        }
    }
}