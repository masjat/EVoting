package com.example.evoting.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.evoting.R
import com.example.evoting.models.Candidate
import com.example.evoting.models.Room
import com.example.evoting.models.Voters

data class AdapterCandidates(
    private val context: Context,
    private val candidates: List<Candidate>
) : ArrayAdapter<Candidate>(context, 0, candidates) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.list_candidates, parent, false)

        // Ambil kandidat berdasarkan posisi
        val candidate = candidates[position]

        // Set data ke view
        val tvName: TextView = view.findViewById(R.id.nmMember)
        val tvIdentity: TextView = view.findViewById(R.id.noIdentity)

        tvName.text = candidate.name
        tvIdentity.text = candidate.identity

        return view
    }
}
