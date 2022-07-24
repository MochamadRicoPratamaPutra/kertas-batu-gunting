package com.rico.challenge4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.rico.challenge4.databinding.ActivityMainBinding
import com.rico.challenge4.model.choice.choiceAvaliable.BATU
import com.rico.challenge4.model.choice.choiceAvaliable.GUNTING
import com.rico.challenge4.model.choice.choiceAvaliable.KERTAS
import com.rico.challenge4.model.result.resultText.DRAW
import com.rico.challenge4.model.result.resultText.WIN
import com.rico.challenge4.model.result.resultText.comWin
import com.rico.challenge4.model.result.resultText.p1Win


class MainActivity : AppCompatActivity() {

    var binding: ActivityMainBinding? = null
    var bgImage: Int = ContextCompat.getColor(this, R.color.secondary3)
    var bgResult: Int = ContextCompat.getColor(this, R.color.secondary1)

    fun blockClick() {
        binding?.ivBatuP1?.isClickable = false
        binding?.ivKertasP1?.isClickable = false
        binding?.ivGuntingP1?.isClickable = false
    }

    private fun playingGame(iv: ImageView, playerChoice: String) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.ivBatuP1?.setOnClickListener {
            binding?.ivBatuP1?.setBackgroundColor(bgImage)

            val mekanik = MekanikGameClass(BATU)
            val comChoice = mekanik.determiningComChoice()
            val result = mekanik.result(comChoice)
            if (result == WIN) {
                binding?.ivKertasP2?.setBackgroundColor(bgImage)
                binding?.tvResult?.text = comWin
            } else if (result == DRAW) {
                binding?.ivBatuP2?.setBackgroundColor(bgImage)
                binding?.tvResult?.text = DRAW

                binding?.tvResult?.setBackgroundColor(bgResult)
            } else {
                binding?.ivGuntingP2?.setBackgroundColor(bgImage)
                binding?.tvResult?.text = p1Win
            }
            binding?.tvResult?.isVisible = true
            blockClick()
        }

        binding?.ivKertasP1?.setOnClickListener {
            var bgImage: Int = ContextCompat.getColor(this, R.color.secondary3)
            binding?.ivKertasP1?.setBackgroundColor(bgImage)
            val mekanik = MekanikGameClass(KERTAS)
            val comChoice = mekanik.determiningComChoice()
            val result = mekanik.result(comChoice)
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
            val mekanik = MekanikGameClass(GUNTING)
            val comChoice = mekanik.determiningComChoice()
            val result = mekanik.result(comChoice)
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