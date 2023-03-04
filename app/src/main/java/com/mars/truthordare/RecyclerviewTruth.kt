package com.mars.truthordare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerviewTruth : AppCompatActivity() {
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapterTruth.ViewHolder>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyler_view)

        layoutManager = LinearLayoutManager(this)
        val rv : RecyclerView = findViewById(R.id.RV)
        rv.layoutManager = layoutManager
        adapter = RecyclerAdapterTruth()
        rv.adapter = adapter
    }
}