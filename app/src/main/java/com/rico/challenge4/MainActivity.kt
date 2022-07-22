package com.rico.challenge4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.rico.challenge4.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    var binding: ActivityMainBinding? = null
    val BATU = "batu"
    val GUNTING = "gunting"
    val KERTAS = "kertas"
    val WIN = "win"
    val DRAW = "draw"

    fun blockClick() {
        binding?.ivBatuP1?.isClickable = false
        binding?.ivKertasP1?.isClickable = false
        binding?.ivGuntingP1?.isClickable = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.ivBatuP1?.setOnClickListener {
            var bgImage: Int = ContextCompat.getColor(this, R.color.secondary3)
            binding?.ivBatuP1?.setBackgroundColor(bgImage)
            val rng: Int = (1..3).random()
            val possibleChoice = arrayListOf<String>("gunting", "batu", "kertas")
            val comChoice = possibleChoice.random()

            val mekanik = MekanikGameClass(BATU, comChoice)
            val result = mekanik.result()
            if (result == WIN) {
                binding?.ivKertasP2?.setBackgroundColor(bgImage)
                binding?.tvResult?.text = "Player 2 Menang"
            } else if (result == DRAW) {
                binding?.ivBatuP2?.setBackgroundColor(bgImage)
                binding?.tvResult?.text = "Draw"
                var bgResult: Int = ContextCompat.getColor(this, R.color.secondary1)
                binding?.tvResult?.setBackgroundColor(bgResult)
            } else {
                binding?.ivGuntingP2?.setBackgroundColor(bgImage)
                binding?.tvResult?.text = "Player 1 Menang"
            }
            binding?.tvResult?.isVisible = true
            blockClick()
        }

        binding?.ivKertasP1?.setOnClickListener {
            var bgImage: Int = ContextCompat.getColor(this, R.color.secondary3)
            binding?.ivKertasP1?.setBackgroundColor(bgImage)
            val rng: Int = (1..3).random()
            val possibleChoice = arrayListOf<String>("gunting", "batu", "kertas")
            val comChoice = possibleChoice.random()

            val mekanik = MekanikGameClass(KERTAS, comChoice)
            val result = mekanik.result()
            if (result == WIN) {
                binding?.ivGuntingP2?.setBackgroundColor(bgImage)
                binding?.tvResult?.text = "Player 2 Menang"
            } else if (result == DRAW) {
                binding?.ivKertasP2?.setBackgroundColor(bgImage)
                binding?.tvResult?.text = "Draw"
                var bgResult: Int = ContextCompat.getColor(this, R.color.secondary1)
                binding?.tvResult?.setBackgroundColor(bgResult)
            } else {
                binding?.ivBatuP2?.setBackgroundColor(bgImage)
                binding?.tvResult?.text = "Player 1 Menang"
            }
            binding?.tvResult?.isVisible = true
            blockClick()
        }

        binding?.ivGuntingP1?.setOnClickListener {
            var bgImage: Int = ContextCompat.getColor(this, R.color.secondary3)
            binding?.ivGuntingP1?.setBackgroundColor(bgImage)
            val rng: Int = (1..3).random()
            val possibleChoice = arrayListOf<String>("gunting", "batu", "kertas")
            val comChoice = possibleChoice.random()

            val mekanik = MekanikGameClass(GUNTING, comChoice)
            val result = mekanik.result()
            if (result == WIN) {
                binding?.ivBatuP2?.setBackgroundColor(bgImage)
                binding?.tvResult?.text = "Player 2 Menang"
            } else if (result == DRAW) {
                binding?.ivGuntingP2?.setBackgroundColor(bgImage)
                binding?.tvResult?.text = "Draw"
                var bgResult: Int = ContextCompat.getColor(this, R.color.secondary1)
                binding?.tvResult?.setBackgroundColor(bgResult)
            } else {
                binding?.ivKertasP2?.setBackgroundColor(bgImage)
                binding?.tvResult?.text = "Player 1 Menang"
            }
            binding?.tvResult?.isVisible = true
            blockClick()
        }

        binding?.ivRestart?.setOnClickListener {
            binding?.ivBatuP1?.isClickable = true
            binding?.ivKertasP1?.isClickable = true
            binding?.ivGuntingP1?.isClickable = true
            binding?.tvResult?.isVisible = false
            binding?.ivGuntingP2?.setBackgroundColor(0)
            binding?.ivGuntingP1?.setBackgroundColor(0)
            binding?.ivKertasP1?.setBackgroundColor(0)
            binding?.ivKertasP2?.setBackgroundColor(0)
            binding?.ivBatuP1?.setBackgroundColor(0)
            binding?.ivBatuP2?.setBackgroundColor(0)
        }
    }
}