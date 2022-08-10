package com.rico.challenge4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rico.challenge4.adapter.ViewPagerAdapter
import com.rico.challenge4.databinding.ActivityLandingPageBinding

class LandingPageActivity : AppCompatActivity() {

    var binding: ActivityLandingPageBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLandingPageBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val viewPagerAdapter = ViewPagerAdapter(this)
        binding?.vpFragment?.adapter = viewPagerAdapter
    }
}