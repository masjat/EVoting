package com.example.evoting.activity

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.evoting.R
import java.util.Calendar

class Profile : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Initialize views
        val btnBack: Button = findViewById(R.id.btnBack)
        val imView: View = findViewById(R.id.imView)  // Foto profil yang bisa diklik
        val etBornDate: EditText = findViewById(R.id.etBornDate)
        val spinnerGender: Spinner = findViewById(R.id.etGender)  // Menggunakan Spinner untuk jenis kelamin
        val btnChange: Button = findViewById(R.id.btnChange)

        // Handle back button
        btnBack.setOnClickListener {
            finish() // Kembali ke halaman sebelumnya hanya jika tombol Back yang diklik
        }

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
        btnChange.setOnClickListener {
            saveProfileData()
        }

        // Handle click on the image view (profile picture)
        imView.setOnClickListener {
            // Open ChangePhotoProfile activity (Untuk mengganti foto profil)
            val intent = Intent(this, ChangePhotoProfile::class.java)
            startActivity(intent) // Memulai activity untuk mengganti foto profil
        }
    }

    // Show DatePickerDialog when editing Born Date
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

    // Example function to save profile data
    private fun saveProfileData() {
        val etUsername: EditText = findViewById(R.id.etUsername)
        val etEmail: EditText = findViewById(R.id.etEmail)
        val etBornPlace: EditText = findViewById(R.id.etBornPlace)
        val etBornDate: EditText = findViewById(R.id.etBornDate)
        val spinnerGender: Spinner = findViewById(R.id.etGender) // Menggunakan Spinner untuk jenis kelamin

        // Get data from EditTexts and Spinner
        val username = etUsername.text.toString()
        val email = etEmail.text.toString()
        val bornPlace = etBornPlace.text.toString()
        val bornDate = etBornDate.text.toString()
        val gender = spinnerGender.selectedItem.toString()  // Mengambil nilai yang dipilih di Spinner

        // Example validation
        if (username.isEmpty() || email.isEmpty() || bornPlace.isEmpty() || bornDate.isEmpty() || gender == "Pilih Jenis Kelamin") {
            Toast.makeText(this, "Semua data harus diisi!", Toast.LENGTH_SHORT).show()
        } else {
            // Perform save action (e.g., send to server or save locally)
            Toast.makeText(this, "Data berhasil disimpan!", Toast.LENGTH_SHORT).show()
        }
    }
}
