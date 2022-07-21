package com.rico.challenge4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.rico.challenge4.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.ivBatuP1?.setOnClickListener {
            var bgImage: Int = ContextCompat.getColor(this, R.color.secondary3)
            binding?.ivBatuP1?.setBackgroundColor(bgImage)
            val rng: Int = (1..3).random()
            if (rng == 1) {
                binding?.ivKertasP2?.setBackgroundColor(bgImage)
                binding?.tvResult?.text = "Player 2 Menang"
                binding?.tvResult?.isVisible = true
            } else if (rng == 2) {
                binding?.ivBatuP2?.setBackgroundColor(bgImage)
                binding?.tvResult?.text = "Draw"
                var bgResult: Int = ContextCompat.getColor(this, R.color.secondary1)
                binding?.tvResult?.setBackgroundColor(bgResult)
                binding?.tvResult?.isVisible = true
            } else {
                binding?.ivGuntingP2?.setBackgroundColor(bgImage)
                binding?.tvResult?.text = "Player 1 Menang"
                binding?.tvResult?.isVisible = true
            }
        }
    }
}