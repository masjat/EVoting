package com.example.evoting.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.evoting.R
import com.example.evoting.models.Committee

class AdapterCommittee (private val context: Context,
                        private val data: List<Committee>
) : BaseAdapter() {

    override fun getCount(): Int = data.size

    override fun getItem(position: Int): Any = data[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.list_committee, parent, false)


        val textView: TextView = view.findViewById(R.id.nmMember)
        val textView2: TextView = view.findViewById(R.id.noIdentity)

        val committee = data[position]
        textView.text = committee.name
        textView2.text = committee.identity

        return view
    }
}