package com.example.evoting.utils

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import com.example.evoting.R

object CustomDialogUtil {
    /**
     * Menampilkan dialog kustom.
     *
     * @param context Context dari Activity/Fragment
     * @param message Pesan yang ingin ditampilkan
     * @param positiveButtonText Teks untuk tombol positif
     * @param positiveButtonAction Aksi yang dijalankan saat tombol positif diklik
     * @param negativeButtonText Teks untuk tombol negatif
     * @param negativeButtonAction Aksi yang dijalankan saat tombol negatif diklik
     */
    fun showCustomDialog(
        context: Context,
        message: String,
        positiveButtonText: String,
        positiveButtonAction: (() -> Unit)? = null,
        negativeButtonText: String,
        negativeButtonAction: (() -> Unit)? = null
    ) {
        // Buat AlertDialog.Builder

        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_custom, null)

        // Hubungkan tampilan dengan id
        val messageTextView: TextView = dialogView.findViewById(R.id.tvTitle)
        val positiveButton: Button = dialogView.findViewById(R.id.btnYes)
        val negativeButton: Button = dialogView.findViewById(R.id.btnNo)

        // Set teks pesan dan tombol
        messageTextView.text = message
        positiveButton.text = positiveButtonText
        negativeButton.text = negativeButtonText

        // Buat dan tampilkan dialog
        val builder = AlertDialog.Builder(context, R.style.RoundedDialogTheme)
        builder.setView(dialogView)
        val dialog = builder.create()


        // Set listener untuk tombol
        positiveButton.setOnClickListener {
            positiveButtonAction?.invoke()
            // Tutup dialog
            dialog.dismiss()
        }
        negativeButton.setOnClickListener {
            negativeButtonAction?.invoke()
            // Tutup dialog
            dialog.dismiss()
        }

        dialog.show()


    }
}
