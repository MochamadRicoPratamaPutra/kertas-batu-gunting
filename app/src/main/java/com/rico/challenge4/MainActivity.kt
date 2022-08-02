package com.rico.challenge4

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.rico.challenge4.databinding.ActivityMainBinding
import com.rico.challenge4.model.ChoiceAvaliable.BATU
import com.rico.challenge4.model.ChoiceAvaliable.GUNTING
import com.rico.challenge4.model.ChoiceAvaliable.KERTAS
import com.rico.challenge4.model.ResultText.DRAW
import com.rico.challenge4.model.ResultText.WIN


class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    private fun blockClick() {
        binding?.ivBatuP1?.isClickable = false
        binding?.ivKertasP1?.isClickable = false
        binding?.ivGuntingP1?.isClickable = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val BG_IMAGE: Drawable? = ContextCompat.getDrawable(this, R.drawable.border_radius_shape)
        val BG_RESULT_DRAW: Int = ContextCompat.getColor(this, R.color.secondary1)
        val BG_RESULT_WIN_LOSE: Int = ContextCompat.getColor(this, R.color.secondary4)
        val BG_TEXT_RESULT: Int = ContextCompat.getColor(this, R.color.white)
        val PLAYER1_WIN_TEXT: String = getString(R.string.player_1_win)
        val PLAYER2_WIN_TEXT: String = getString(R.string.player_2_win)
        val DRAW_TEXT:String = getString(R.string.draw_result)

        binding?.ivBatuP1?.setOnClickListener {
            binding?.ivBatuP1?.background = BG_IMAGE
            binding?.tvResult?.textSize = 20F
            binding?.tvResult?.setTextColor(BG_TEXT_RESULT)
            val mekanik = MekanikGameClass(BATU)
            val COM_CHOICE = mekanik.determiningComChoice()
            Log.d("Player Choice", "Pemain 1: Batu, Pemain 2 : $COM_CHOICE")
            when (mekanik.result(COM_CHOICE)) {
                WIN -> {
                    binding?.ivGuntingP2?.background = BG_IMAGE
                    binding?.tvResult?.text = PLAYER1_WIN_TEXT
                    binding?.tvResult?.setBackgroundColor(BG_RESULT_WIN_LOSE)
                }
                DRAW -> {
                    binding?.ivBatuP2?.background = BG_IMAGE
                    binding?.tvResult?.text = DRAW_TEXT
                    binding?.tvResult?.setBackgroundColor(BG_RESULT_DRAW)
                }
                else -> {
                    binding?.ivKertasP2?.background = BG_IMAGE
                    binding?.tvResult?.text = PLAYER2_WIN_TEXT
                    binding?.tvResult?.setBackgroundColor(BG_RESULT_WIN_LOSE)
                }
            }
            binding?.tvResult?.isVisible = true
            Log.d("Result", "Pemain 1 ${mekanik.result(COM_CHOICE)}")
            blockClick()
        }

        binding?.ivKertasP1?.setOnClickListener {
            binding?.ivKertasP1?.background = BG_IMAGE
            binding?.tvResult?.textSize = 20F
            binding?.tvResult?.setTextColor(BG_TEXT_RESULT)
            val mekanik = MekanikGameClass(KERTAS)
            val COM_CHOICE = mekanik.determiningComChoice()
            Log.d("Player Choice", "Pemain 1: Kertas, Pemain 2 : $COM_CHOICE")
            when (mekanik.result(COM_CHOICE)) {
                WIN -> {
                    binding?.ivBatuP2?.background = BG_IMAGE
                    binding?.tvResult?.text = PLAYER1_WIN_TEXT
                    binding?.tvResult?.setBackgroundColor(BG_RESULT_WIN_LOSE)

                }
                DRAW -> {
                    binding?.ivKertasP2?.background = BG_IMAGE
                    binding?.tvResult?.text = DRAW_TEXT
                    binding?.tvResult?.setBackgroundColor(BG_RESULT_DRAW)
                }
                else -> {
                    binding?.ivGuntingP2?.background = BG_IMAGE
                    binding?.tvResult?.text = PLAYER2_WIN_TEXT
                    binding?.tvResult?.setBackgroundColor(BG_RESULT_WIN_LOSE)
                }
            }
            binding?.tvResult?.isVisible = true
            Log.d("Result", "Pemain 1 ${mekanik.result(COM_CHOICE)}")
            blockClick()
        }

        binding?.ivGuntingP1?.setOnClickListener {
            binding?.ivGuntingP1?.background = BG_IMAGE
            binding?.tvResult?.textSize = 20F
            binding?.tvResult?.setTextColor(BG_TEXT_RESULT)
            val mekanik = MekanikGameClass(GUNTING)
            val COM_CHOICE = mekanik.determiningComChoice()
            Log.d("Player Choice", "Pemain 1: Gunting, Pemain 2 : $COM_CHOICE")
            when (mekanik.result(COM_CHOICE)) {
                WIN -> {
                    binding?.ivKertasP2?.background = BG_IMAGE
                    binding?.tvResult?.text = PLAYER1_WIN_TEXT
                    binding?.tvResult?.setBackgroundColor(BG_RESULT_WIN_LOSE)
                }
                DRAW -> {
                    binding?.ivGuntingP2?.background = BG_IMAGE
                    binding?.tvResult?.text = DRAW_TEXT
                    binding?.tvResult?.setBackgroundColor(BG_RESULT_DRAW)
                }
                else -> {
                    binding?.ivBatuP2?.background = BG_IMAGE
                    binding?.tvResult?.text = PLAYER2_WIN_TEXT
                    binding?.tvResult?.setBackgroundColor(BG_RESULT_WIN_LOSE)
                }
            }
            binding?.tvResult?.isVisible = true
            Log.d("Result", "Pemain 1 ${mekanik.result(COM_CHOICE)}")
            blockClick()
        }

        binding?.ivRestart?.setOnClickListener {
            val VS = "VS"
            binding?.ivBatuP1?.isClickable = true
            binding?.ivKertasP1?.isClickable = true
            binding?.ivGuntingP1?.isClickable = true
            binding?.tvResult?.isVisible = true
            binding?.tvResult?.text = VS
            binding?.tvResult?.setTextColor(ContextCompat.getColor(this, R.color.secondary5))
            binding?.tvResult?.setBackgroundColor(0)
            binding?.tvResult?.textSize = 50f
            binding?.ivGuntingP2?.setBackgroundColor(0)
            binding?.ivGuntingP1?.setBackgroundColor(0)
            binding?.ivKertasP1?.setBackgroundColor(0)
            binding?.ivKertasP2?.setBackgroundColor(0)
            binding?.ivBatuP1?.setBackgroundColor(0)
            binding?.ivBatuP2?.setBackgroundColor(0)
        }
    }
}