package com.example.evoting.activity

import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.evoting.R
import com.example.evoting.adapter.AdapterCandidate
import com.example.evoting.models.Candidate

class DashboardRoom: AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AdapterCandidate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard_room)

        val ivBack = findViewById<ImageView>(R.id.ivBack)
        val ivMenu = findViewById<ImageView>(R.id.ivMenu)

        ivBack.setOnClickListener {
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }
        ivMenu.setOnClickListener {
            val intent = Intent(this, RoomSetting::class.java)
            startActivity(intent)
        }

        recyclerView = findViewById(R.id.recyclerView_candidate)
        val gridLayoutManager = GridLayoutManager(this, 1) // Menyusun dalam 2 kolom
        recyclerView.layoutManager = gridLayoutManager
        adapter = AdapterCandidate(getData(), { candidate ->
            // Handle klik item, misalnya buka halaman detail
            val intent = Intent(this, DetailCandidate::class.java)
            startActivity(intent)
        }, { candidate ->
            // Handle klik tombol Pilih
            Toast.makeText(this, "Kandidat ${candidate.no} dipilih", Toast.LENGTH_SHORT).show()
        })
        recyclerView.adapter = adapter

        val spacing = resources.getDimensionPixelSize(R.dimen.spacing)
        recyclerView.addItemDecoration(ItemSpacingDecoration(spacing))
    }

    private fun getData(): List<Candidate> {
        return listOf(
            Candidate("1", R.drawable.candidate,"a","1"),
            Candidate("2", R.drawable.candidate,"a","1"),
            Candidate("3", R.drawable.candidate,"a","1"),
            Candidate("4", R.drawable.candidate,"a","1")
        )
    }

    class ItemSpacingDecoration(private val spacing: Int) : RecyclerView.ItemDecoration() {
        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
            outRect.left = spacing
            outRect.right = spacing
            outRect.top = spacing
            outRect.bottom = spacing
        }
    }
}
