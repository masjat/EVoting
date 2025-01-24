package com.example.evoting.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.evoting.R
import com.example.evoting.models.Room

class AdapterRoom(
    private val data: List<Room>,
    private val onItemClick : (Room) -> Unit
) : RecyclerView.Adapter<AdapterRoom.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val roomName: TextView = itemView.findViewById(R.id.tv_room_name)
        val roomCapacity: TextView = itemView.findViewById(R.id.tv_room_capacity)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_room, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val room = data[position]
        holder.roomName.text = room.name
        holder.roomCapacity.text = room.date
        holder.imageView.setImageResource(R.drawable.baseline_vote_white)

        holder.itemView.setOnClickListener {
            onItemClick(room)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
