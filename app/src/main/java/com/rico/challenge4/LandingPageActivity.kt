package com.rico.challenge4

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
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

        binding?.let {
            it.ciPager.setViewPager(binding?.vpFragment)
        }

        binding?.vpFragment?.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding?.ivNextActivity?.apply {
                    when (position) {
                        0 -> {
                            visibility = View.GONE
                        }
                        1 -> {
                            visibility = View.VISIBLE
                            setOnClickListener {
                                binding?.vpFragment?.currentItem = position + 1
                            }
                        }
                        2 -> {
                            visibility = View.VISIBLE
                            setOnClickListener {
                                if (data.isNullOrEmpty()) {
                                    Toast.makeText(this@LandingPageActivity, getString(R.string.nama_belum_terisi), Toast.LENGTH_SHORT).show()
                                } else {
                                    val intent =
                                        Intent(
                                            this@LandingPageActivity,
                                            ChoosingEnemyActivity::class.java
                                        )
                                    intent.putExtra(USERNAME, data)
                                    startActivity(intent)
                                    finish()
                                }
                            }
                        }
                    }
                }
            }
        })
    }

    fun handleData(value: String) {
        data = value
    }
}