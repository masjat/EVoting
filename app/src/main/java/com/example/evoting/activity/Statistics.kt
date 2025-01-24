package com.example.evoting.activity

import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.evoting.R
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter

class Statistics:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistics)

        val backButton = findViewById<ImageView>(R.id.back_button)
        val pieChart: PieChart = findViewById(R.id.crtPie)

        backButton.setOnClickListener {
            finish()
        }
        val pieEntries = listOf(
            PieEntry(40f, "Android"),
            PieEntry(30f, "iOS"),
            PieEntry(30f, "Windows")
        )

        // Warna dari resources
        val colors = listOf(
            getColor(R.color.red), // Orange
            getColor(R.color.yellow), // Green
            getColor(R.color.chocolate)  // Blue
        )

        // Atur dataset
        val pieDataSet = PieDataSet(pieEntries, "Platform")
        pieDataSet.colors = colors
        pieDataSet.valueTextSize = 14f
        pieDataSet.valueTextColor = Color.WHITE  // Warna angka persentase
        pieDataSet.valueFormatter = PercentFormatter(pieChart)  // Format angka ke persentase

        // Set data ke Pie Chart
        val pieData = PieData(pieDataSet)
        pieChart.data = pieData

        // Konfigurasi tambahan
        pieChart.description.isEnabled = false
        pieChart.setUsePercentValues(true) // Aktifkan mode persentase
        pieChart.setEntryLabelColor(Color.WHITE) // Warna nama item
        pieChart.setEntryLabelTextSize(12f)      // Ukuran nama item
        pieChart.animateY(1000)                 // Animasi Pie Chart
        pieChart.invalidate()                   // Refresh Pie Chart
    }

}