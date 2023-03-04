package com.mars.truthordare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerviewDare : AppCompatActivity() {
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapterDare.ViewHolder>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyler_view)
        val header : TextView = findViewById(R.id.header_title)
        header.text = getString(R.string.dare)
        layoutManager = LinearLayoutManager(this)
        val rv : RecyclerView = findViewById(R.id.RV)
        rv.layoutManager = layoutManager
        adapter = RecyclerAdapterDare()
        rv.adapter = adapter
    }
}