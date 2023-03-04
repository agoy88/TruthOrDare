package com.mars.truthordare

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.annotation.RequiresApi

class SplashActivity : AppCompatActivity() {
    private val SPLASH_SCREEN_DURATION = 2500
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setStatusBar()
        Handler().postDelayed({
            startActivity(Intent(this, GettingStarted::class.java))
            finish()
        },SPLASH_SCREEN_DURATION.toLong())

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
        findViewById<View>(R.id.imageView2).setPadding(0, topInset, 0, 0)
    }
}