package com.example.evoting.activity

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.evoting.R
import com.example.evoting.models.Room
import com.example.evoting.adapter.AdapterRoom
import com.example.evoting.utils.GridSpacingItemDecoration // Import kelas ItemDecoration
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Dashboard : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapterRoom: AdapterRoom
    private var isListView = true // Default tampilan grid
    private val roomList = mutableListOf<Room>() // Data ruangan
    private var isFabExpanded = false // Status FAB (default tersembunyi)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        // Inisialisasi RecyclerView
        recyclerView = findViewById(R.id.recyclerView_room)
        setupRecyclerView()

        // Tombol Toggle View (Grid/List)
        val btnGrid = findViewById<ImageButton>(R.id.btnGrid)
        val btnList = findViewById<ImageButton>(R.id.btnList)
        val tvSort = findViewById<TextView>(R.id.tvSort)
        val fabMain = findViewById<FloatingActionButton>(R.id.fab_add)
        val llCreateRoom = findViewById<View>(R.id.ll_create_room)
        val llJoinRoom = findViewById<View>(R.id.ll_join_room)
        val imMenu = findViewById<ImageButton>(R.id.imMenu)

        fabMain.setOnClickListener {
            toggleFabMenu(llCreateRoom, llJoinRoom)
        }

        llCreateRoom.setOnClickListener {
            val intent = Intent(this, CreateRoom::class.java)
            startActivity(intent)
        }
        llJoinRoom.setOnClickListener {
            val intent = Intent(this, JoinRoom::class.java)
            startActivity(intent)
        }
        imMenu.setOnClickListener {
            val intent = Intent(this, Menus::class.java)
            startActivity(intent)
        }

        tvSort.setOnClickListener {
            showSortMenu(it, tvSort)
        }

        // Atur transparansi awal
        btnGrid.alpha = 0.5f // Transparan (tidak aktif)
        btnList.alpha = 1.0f // Tidak transparan (aktif)

        btnGrid.setOnClickListener {
            isListView = false
            setupRecyclerView()
            // Ubah transparansi tombol
            btnGrid.alpha = 1.0f // Grid aktif
            btnList.alpha = 0.5f // List tidak aktif
        }

        btnList.setOnClickListener {
            isListView = true
            setupRecyclerView()
            // Ubah transparansi tombol
            btnList.alpha = 1.0f // List aktif
            btnGrid.alpha = 0.5f // Grid tidak aktif
        }

        // Tambahkan data dummy untuk pengujian
        populateDummyData()

        // Hubungkan adapter dengan RecyclerView
        adapterRoom = AdapterRoom(roomList) { room ->
            val intent = Intent(this, DashboardRoom::class.java)
            intent.putExtra("ROOM_NAME", room.name) // Kirim nama ruang ke halaman berikutnya
            startActivity(intent)
        }
        recyclerView.adapter = adapterRoom
    }


    private fun setupRecyclerView() {
        recyclerView.layoutManager = if (isListView) {
            LinearLayoutManager(this) // List vertikal
        } else {
            GridLayoutManager(this, 2) // Grid dengan 2 kolom
        }

        // Pastikan ItemDecoration hanya ditambahkan sekali
        if (recyclerView.itemDecorationCount == 0) {
            val spacingInPixels = resources.getDimensionPixelSize(R.dimen.spacing)
            recyclerView.addItemDecoration(GridSpacingItemDecoration(spacingInPixels))
        }
    }


    private fun populateDummyData() {
        roomList.apply {
            add(Room("Room 1", "2025-01-01"))
            add(Room("Room 2", "2025-01-02"))
            add(Room("Room 3", "2025-01-03"))
            add(Room("Room 4", "2025-01-04"))
            add(Room("Room 5", "2025-01-05"))
        }
    }
    // Fungsi untuk menampilkan menu sort
    private fun showSortMenu(anchorView: View, tvSort: TextView) {
        val popupMenu = PopupMenu(this, anchorView)
        popupMenu.menuInflater.inflate(R.menu.menu_sort_options, popupMenu.menu)

        // Atur listener saat item dipilih
        popupMenu.setOnMenuItemClickListener { menuItem ->
            handleSortOption(menuItem, tvSort)
            true
        }

        // Tampilkan menu
        popupMenu.show()
    }

    // Fungsi untuk menangani pilihan menu
    private fun handleSortOption(menuItem: MenuItem, tvSort: TextView) {
        when (menuItem.itemId) {
            R.id.menu_lama -> tvSort.text = "Lama"
            R.id.menu_admin -> tvSort.text = "Panitia"
            R.id.menu_pemilih -> tvSort.text = "Pemilih"
            R.id.menu_terbaru -> tvSort.text = "Terbaru"
        }
    }
    private fun toggleFabMenu(llCreateRoom: View, llJoinRoom: View) {
        if (isFabExpanded) {
            // Sembunyikan tombol
            llCreateRoom.visibility = View.GONE
            llJoinRoom.visibility = View.GONE
        } else {
            // Tampilkan tombol
            llCreateRoom.visibility = View.VISIBLE
            llJoinRoom.visibility = View.VISIBLE
        }
        isFabExpanded = !isFabExpanded
    }
}
