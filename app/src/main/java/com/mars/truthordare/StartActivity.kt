package com.mars.truthordare

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class StartActivity : AppCompatActivity() {


    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        setStatusBar()
        val playButton: Button = findViewById(R.id.button_mainActivity)
//        val truthButton: Button = findViewById(R.id.truth_button_start)
//        val dareButton: Button = findViewById(R.id.dare_button_start)
        playButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))

        }
//        truthButton.setOnClickListener {
//            startActivity(Intent(this, RecyclerviewTruth::class.java))
//        }
//        dareButton.setOnClickListener {
//            startActivity(Intent(this, RecyclerviewDare::class.java))
//        }
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        AlertDialog.Builder(this)
            .setMessage("Apakah Anda yakin ingin menutup aplikasi?")
            .setCancelable(false)
            .setPositiveButton("Ya") { _, _ ->
                finish()
            }
            .setNegativeButton("Tidak", null)
            .show()
    }


    @RequiresApi(Build.VERSION_CODES.Q)
    private fun setStatusBar() {
        val decorView = window.decorView
        decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        window.statusBarColor = Color.TRANSPARENT
        val insets = decorView.rootWindowInsets
        val stableInsets = insets?.stableInsets
        val topInset = stableInsets?.top ?: 0
        findViewById<View>(R.id.topShape).setPadding(0, topInset, 0, 0)
    }
}