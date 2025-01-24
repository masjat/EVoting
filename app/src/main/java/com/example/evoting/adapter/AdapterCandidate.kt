package com.example.evoting.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.evoting.R
import com.example.evoting.models.Candidate

class AdapterCandidate(
    private val itemList: List<Candidate>, // Data yang akan ditampilkan
    private val onItemImage: (Candidate) -> Unit, // Callback untuk klik item
    private val onItemSelect: (Candidate) -> Unit // Callback untuk klik tombol Pilih
) : RecyclerView.Adapter<AdapterCandidate.ItemViewHolder>() {

    // ViewHolder untuk item
    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val noCandidate: TextView = view.findViewById(R.id.noCandidate)
        val ftCandidat: ImageView = view.findViewById(R.id.ftCandidat)
        val btnVote: Button = view.findViewById(R.id.btnVote) // Ubah TextView menjadi Button
    }

    // Inflate layout untuk item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_candidate, parent, false)
        return ItemViewHolder(view)
    }

    // Menghubungkan data ke tampilan
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val candidate = itemList[position]
        holder.noCandidate.text = candidate.no // Menetapkan nomor kandidat

        // Menetapkan gambar lokal ke ImageView menggunakan ID resource
        holder.ftCandidat.setImageResource(candidate.photo)

        // Menambahkan event klik pada item
        holder.ftCandidat.setOnClickListener {
            onItemImage(candidate) // Panggil callback saat item diklik
        }

        // Menambahkan event klik pada tombol "Pilih"
        holder.btnVote.setOnClickListener {
            onItemSelect(candidate) // Panggil callback saat tombol Pilih diklik
        }
    }

    // Mengembalikan jumlah item dalam daftar
    override fun getItemCount(): Int = itemList.size
}
