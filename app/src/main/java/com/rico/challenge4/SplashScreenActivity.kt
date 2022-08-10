package com.rico.challenge4

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.rico.challenge4.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {

    var binding: ActivitySplashScreenBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        supportActionBar?.hide()

//        binding?.apply {
//            Glide.with(this@SplashScreenActivity)
//                .load("https://i.ibb.co/HC5ZPgD/splash-screen1.png").into(ivLogoText)
//        }

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@SplashScreenActivity, ChoosingEnemyActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}