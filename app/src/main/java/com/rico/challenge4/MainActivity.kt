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
    var player1Choice = "DEFAULT"

    var BG_IMAGE = R.drawable.border_radius_shape

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val enemyType = intent.getStringExtra(ENEMY_TYPE)
        binding?.apply {
            ivBatuP1.setOnClickListener {
                player1Choice = BATU
                bgChoosenImage(ivBatuP1)
                if (enemyType == getString(R.string.enemy_cpu)) {
                    gameFunctionCpu(player1Choice)
                }
                blockClick()
            }
            ivGuntingP1.setOnClickListener {
                player1Choice = GUNTING
                bgChoosenImage(ivGuntingP1)
                if (enemyType == getString(R.string.enemy_cpu)) {
                    gameFunctionCpu(player1Choice)
                }
                blockClick()
            }
            ivKertasP1.setOnClickListener {
                player1Choice = KERTAS
                bgChoosenImage(ivKertasP1)
                if (enemyType == getString(R.string.enemy_cpu)) {
                    gameFunctionCpu(player1Choice)
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
                binding?.tvResult?.setTextColor(
                    ContextCompat.getColor(
                        this@MainActivity,
                        R.color.secondary5
                    )
                )
                binding?.tvResult?.setBackgroundColor(BG_COLOR)
                binding?.tvResult?.textSize = TEXT_SIZE
                binding?.ivGuntingP2?.setBackgroundColor(BG_COLOR)
                binding?.ivGuntingP1?.setBackgroundColor(BG_COLOR)
                binding?.ivKertasP1?.setBackgroundColor(BG_COLOR)
                binding?.ivKertasP2?.setBackgroundColor(BG_COLOR)
                binding?.ivBatuP1?.setBackgroundColor(BG_COLOR)
                binding?.ivBatuP2?.setBackgroundColor(BG_COLOR)
            }
            ivGuntingP2.setOnClickListener {
                if (enemyType == getString(R.string.enemy_friend) && player1Choice != "DEFAULT") {
                    bgChoosenImage(ivGuntingP2)
                    gameFunctionFriend(player1Choice, GUNTING)
                }
            }
            ivKertasP2.setOnClickListener {
                if (enemyType == getString(R.string.enemy_friend) && player1Choice != "DEFAULT") {
                    bgChoosenImage(ivKertasP2)
                    gameFunctionFriend(player1Choice, KERTAS)
                }
            }
            ivBatuP2.setOnClickListener {
                if (enemyType == getString(R.string.enemy_friend) && player1Choice != "DEFAULT") {
                    bgChoosenImage(ivBatuP2)
                    gameFunctionFriend(player1Choice, BATU)
                }
            }

        }
    }

    fun gameFunctionCpu(player1Choice: String) {
        val mekanik = MekanikGameClass(player1Choice)
        val COM_CHOICE = mekanik.determiningComChoice()
        Log.d("PLAYERCHOICE", "Pemain 1: $player1Choice, Pemain 2 : $COM_CHOICE")
        when (COM_CHOICE) {
            KERTAS -> {
                binding?.ivKertasP2?.setBackgroundResource(BG_IMAGE)
            }
            BATU -> {
                binding?.ivBatuP2?.setBackgroundResource(BG_IMAGE)
            }
            GUNTING -> {
                binding?.ivGuntingP2?.setBackgroundResource(BG_IMAGE)
            }
        }
        resultGame(mekanik.result(COM_CHOICE))
        Log.d("RESULT", "Pemain 1 ${mekanik.result(COM_CHOICE)}")
    }

    fun bgChoosenImage(playerChoice: ImageView) {
        playerChoice.setBackgroundResource(BG_IMAGE)
    }

    fun gameFunctionFriend(player1Choice: String, player2Choice: String) {
        val mekanik = MekanikGameClass(player1Choice)
        resultGame(mekanik.result(player2Choice))
        Log.d("RESULT", "Pemain 1 ${mekanik.result(player2Choice)}")
        Log.d("PLAYERCHOICE", "Pemain 1: $player1Choice, Pemain 2 : $player2Choice")
    }

    fun resultGame(result: String) {
        val PLAYER1_WIN_TEXT: String = getString(R.string.player_1_win)
        val PLAYER2_WIN_TEXT: String = getString(R.string.player_2_win)
        val DRAW_TEXT: String = getString(R.string.draw_result)
        when (result) {
            WIN -> {
                Toast.makeText(this, PLAYER1_WIN_TEXT, Toast.LENGTH_SHORT).show()
            }
            DRAW -> {
                Toast.makeText(this, DRAW_TEXT, Toast.LENGTH_SHORT).show()
            }
            else -> {
                Toast.makeText(this, PLAYER2_WIN_TEXT, Toast.LENGTH_SHORT).show()
            }
        }
        Log.d("RESULT", "Pemain 1 ${result}")
    }
}