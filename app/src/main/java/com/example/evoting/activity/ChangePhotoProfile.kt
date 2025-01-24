package com.example.evoting.activity

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.evoting.R

class ChangePhotoProfile : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_profile)

        // Initialize views
        val ivBack: ImageView = findViewById(R.id.ivBack)
        val ivEdit: ImageView = findViewById(R.id.ivEdit)
        val tvFotoProfil: TextView = findViewById(R.id.tvFotoProfil)
        val ivFotoProfil: ImageView = findViewById(R.id.ivFotoProfil)

        // Set onClickListener untuk tombol kembali
        ivBack.setOnClickListener {
            finish() // Menutup Activity dan kembali ke halaman sebelumnya
        }

        // Set onClickListener untuk tombol edit
        ivEdit.setOnClickListener {
            // Aksi ketika tombol Edit diklik (misalnya, membuka aktivitas lain atau dialog)
            Toast.makeText(this, "Edit Profil", Toast.LENGTH_SHORT).show()
            // Di sini Anda bisa menambahkan kode untuk membuka form edit atau mengubah data profil
        }

        // Set TextView untuk foto profil
        tvFotoProfil.text = "Foto Profil"

        // Set ImageView untuk foto profil
        ivFotoProfil.setImageResource(R.drawable.profile1) // Set gambar profil yang ada

        // Jika ingin mengubah foto profil, bisa menambahkan aksi seperti membuka galeri atau kamera
        ivFotoProfil.setOnClickListener {
            Toast.makeText(this, "Ganti Foto Profil", Toast.LENGTH_SHORT).show()
            // Implementasi aksi ganti foto profil dapat dilakukan di sini (misalnya membuka kamera atau galeri)
        }
    }
}
