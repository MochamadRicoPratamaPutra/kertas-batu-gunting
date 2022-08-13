package com.rico.challenge4

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.rico.challenge4.adapter.ViewPagerAdapter
import com.rico.challenge4.databinding.ActivityLandingPageBinding
import com.rico.challenge4.model.ExtraSource.USERNAME

class LandingPageActivity : AppCompatActivity() {

    var binding: ActivityLandingPageBinding? = null
    var data: String? = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLandingPageBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val viewPagerAdapter = ViewPagerAdapter(this, ::handleData)
        binding?.vpFragment?.adapter = viewPagerAdapter
        binding?.ivNextActivity?.setOnClickListener {
            val intent = Intent(this@LandingPageActivity, ChoosingEnemyActivity::class.java)
            intent.putExtra(USERNAME, data)
            startActivity(intent)
            finish()
        }

        binding?.vpFragment?.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when (position) {
                    0 -> {

                    }
                    1 -> {

                    }
                }
            }
        })
    }

    fun handleData(value: String) {
        data = value
    }
}