package com.rico.challenge4

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.rico.challenge4.databinding.ActivityMainBinding
import com.rico.challenge4.model.ChoiceAvaliable.BATU
import com.rico.challenge4.model.ChoiceAvaliable.GUNTING
import com.rico.challenge4.model.ChoiceAvaliable.KERTAS
import com.rico.challenge4.model.ExtraSource.ENEMY_TYPE
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
        var player1Choice: String
        var enemyType = intent.getStringExtra(ENEMY_TYPE)
        binding?.apply {
            ivBatuP1.setOnClickListener {
                player1Choice = BATU
                if (enemyType == getString(R.string.enemy_cpu)) {
                    gameFunctionCpu(ivBatuP1, player1Choice)
                }
                blockClick()
            }
            ivGuntingP1.setOnClickListener {
                player1Choice = GUNTING
                if (enemyType == getString(R.string.enemy_cpu)) {
                    gameFunctionCpu(ivGuntingP1, player1Choice)
                }
                blockClick()
            }
            ivKertasP1.setOnClickListener {
                player1Choice = GUNTING
                if (enemyType == getString(R.string.enemy_cpu)) {
                    gameFunctionCpu(ivKertasP1, player1Choice)
                }
                blockClick()
            }
            ivRestart.setOnClickListener {
                val VS = "VS"
                val BG_COLOR = 0
                val TEXT_SIZE = 50f
                binding?.ivBatuP1?.isClickable = true
                binding?.ivKertasP1?.isClickable = true
                binding?.ivGuntingP1?.isClickable = true
                binding?.tvResult?.isVisible = true
                binding?.tvResult?.text = VS
                binding?.tvResult?.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.secondary5))
                binding?.tvResult?.setBackgroundColor(BG_COLOR)
                binding?.tvResult?.textSize = TEXT_SIZE
                binding?.ivGuntingP2?.setBackgroundColor(BG_COLOR)
                binding?.ivGuntingP1?.setBackgroundColor(BG_COLOR)
                binding?.ivKertasP1?.setBackgroundColor(BG_COLOR)
                binding?.ivKertasP2?.setBackgroundColor(BG_COLOR)
                binding?.ivBatuP1?.setBackgroundColor(BG_COLOR)
                binding?.ivBatuP2?.setBackgroundColor(BG_COLOR)
            }
        }
    }

    fun gameFunctionCpu(ivPlayer1Choice: ImageView, choice: String) {
        val BG_IMAGE: Drawable? = ContextCompat.getDrawable(this, R.drawable.border_radius_shape)
        ivPlayer1Choice.background = BG_IMAGE
        val mekanik = MekanikGameClass(choice)
        val COM_CHOICE = mekanik.determiningComChoice()
        Log.d("PLAYERCHOICE", "Pemain 1: Gunting, Pemain 2 : $COM_CHOICE")
        when (COM_CHOICE) {
            KERTAS -> {
                binding?.ivKertasP2?.background = BG_IMAGE
            }
            BATU -> {
                binding?.ivBatuP2?.background = BG_IMAGE
            }
            GUNTING -> {
                binding?.ivGuntingP2?.background = BG_IMAGE
            }
        }
        resultGame(mekanik.result(COM_CHOICE))
        Log.d("RESULT", "Pemain 1 ${mekanik.result(COM_CHOICE)}")
    }

    fun gameFunctionFriend() {

    }

    fun resultGame(result: String) {
        val PLAYER1_WIN_TEXT: String = getString(R.string.player_1_win)
        val PLAYER2_WIN_TEXT: String = getString(R.string.player_2_win)
        val DRAW_TEXT: String = getString(R.string.draw_result)
        when (result) {
            WIN -> {
                Toast.makeText(this, PLAYER1_WIN_TEXT, Toast.LENGTH_LONG).show()
            }
            DRAW -> {
                Toast.makeText(this, DRAW_TEXT, Toast.LENGTH_LONG).show()
            }
            else -> {
                Toast.makeText(this, PLAYER2_WIN_TEXT, Toast.LENGTH_LONG).show()
            }
        }
        Log.d("RESULT", "Pemain 1 ${result}")
    }
}