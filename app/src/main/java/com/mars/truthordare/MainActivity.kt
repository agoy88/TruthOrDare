package com.mars.truthordare


import android.graphics.Color
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.Button
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var btnTruth: Button
    private lateinit var btnDare: Button
    private lateinit var button: Button
    private var mp: MediaPlayer = MediaPlayer()
    private var mainMusic = MediaPlayer()
    private var lastRotation = 0f

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**
         * binding all variable to xml file by id
         */
        imageView = findViewById(R.id.arrow_spin)
        button = findViewById(R.id.button)
        btnTruth = findViewById(R.id.btn_truth)
        btnDare = findViewById(R.id.btn_dare)
        mainMusic = MediaPlayer.create(this, R.raw.ambient_main)
        mainMusic.isLooping = true
        mainMusic.start()
        setStatusBar()

        btnTruth.isEnabled = false
        btnDare.isEnabled = false

        /**
         * menampikan bottom sheet untuk kartu dare dan truth
         */
        val bottomSheetFragmentTruth = BottomSheetFragmentTruth()
        btnTruth.setOnClickListener {
            bottomSheetFragmentTruth.show(supportFragmentManager, "BottomSheetTruth")
        }
        val bottomSheetFragmentDare = BottomSheetFragmentDare()
        btnDare.setOnClickListener {
            bottomSheetFragmentDare.show(supportFragmentManager, "BottomSheetDare")
        }

        /**
         * membuat button yang menampilkan truth card atau dare card aktif secara random ketika
         * button spin di klik
         */
        button.setOnClickListener {
            rotateAnimation()
            val intRandom: Int = (1..2).random()
            animationButton(intRandom)
        }
    }

    /**
     * Melanjutkan backround musik setelah berhenti atau keluar
     * aplikasi
     */
    override fun onResume() {
        super.onResume()
        mainMusic.start()
    }

    /**
     * Mempause dan merelease backround music ketika keluar aplkasi
     */
    override fun onPause() {
        super.onPause()
        mainMusic.stop()
        mainMusic.release()
    }

    private fun animationButton(idButton: Int) {
        btnTruth.isEnabled = false
        btnDare.isEnabled = false
        when (idButton) {
            1 -> {
                btnTruth.isEnabled = true
            }
            2 -> {
                btnDare.isEnabled = true
            }
        }
    }


    private fun rotateAnimation() {

        /**
         * Deklarasi varabel derajat awal dan akhir untuk perputaran botol
         * pivotX dan pivotY digunakan untuk mendefinisikan titik sumbu putaran
         * variabel lastRotation digunakan untuk memutar botol kembali dari posisi akhir botol
         * berhenti
         */
        val ran = Random.nextFloat()
        val fromDegrees = lastRotation
        val toDegrees = lastRotation + 7200f * ran
        val pivotX = imageView.width / 2
        val pivotY = imageView.height / 2

        /**
         * masukan variabel tadi kedalam objek constructor RotateAnimation
         */
        val rotate: Animation = RotateAnimation(
            fromDegrees,
            toDegrees,
            pivotX.toFloat(),
            pivotY.toFloat(),
        )
        /**
         * masukan durasi dalam millisecond
         * funtion fillAfter digunakan agar posisi botol tidak kembali ke posisi awal
         * pada saat animasi berhenti
         */

        rotate.duration = 3000
        rotate.fillAfter = true

        /**
         * setAnimationListener memungkinkan kita untuk menambah beberapa attribute
         * ke dalam animasi pada saat start,end,atau repeat
         */
        rotate.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                mp = MediaPlayer.create(this@MainActivity, R.raw.audio)
                mp.start()
                button.isEnabled = false
            }

            override fun onAnimationEnd(animation: Animation?) {
                mp.stop()
                mp.release()
                button.isEnabled = true
            }

            override fun onAnimationRepeat(animation: Animation?) {}
        })
        lastRotation = toDegrees
        imageView.startAnimation(rotate)
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
        findViewById<View>(R.id.topMain).setPadding(0, topInset, 0, 0)
    }


}