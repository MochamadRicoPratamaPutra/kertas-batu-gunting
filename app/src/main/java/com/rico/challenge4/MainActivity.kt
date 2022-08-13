package com.rico.challenge4

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.rico.challenge4.databinding.ActivityMainBinding
import com.rico.challenge4.model.ChoiceAvaliable.BATU
import com.rico.challenge4.model.ChoiceAvaliable.GUNTING
import com.rico.challenge4.model.ChoiceAvaliable.KERTAS
import com.rico.challenge4.model.ExtraSource.ENEMY_TYPE
import com.rico.challenge4.model.ExtraSource.USERNAME
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

    lateinit var winner: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val enemyType = intent.getStringExtra(ENEMY_TYPE)
        val username = intent.getStringExtra(USERNAME)
        binding?.apply {

            tvP1.text = username.toString()

            if (enemyType == getString(R.string.enemy_friend)) {
                tvStatusPlayer.text = String.format(getString(R.string.pemain_sedang_memilih, "1"))
            } else {
                tvStatusPlayer.visibility = View.GONE
            }

            ivBatuP1.setOnClickListener {
                onClickPlayer1Choice(ivBatuP1, BATU, enemyType)
            }
            ivGuntingP1.setOnClickListener {
                onClickPlayer1Choice(ivGuntingP1, GUNTING, enemyType)
            }
            ivKertasP1.setOnClickListener {
                onClickPlayer1Choice(ivKertasP1, KERTAS, enemyType)
            }
            ivRestart.setOnClickListener {
                resetState()
            }
            ivGuntingP2.setOnClickListener {
                if (enemyType == getString(R.string.enemy_friend) && player1Choice != "DEFAULT") {
                    when (player1Choice) {
                        KERTAS -> {
                            bgChoosenImage(ivKertasP1)
                        }
                        GUNTING -> {
                            bgChoosenImage(ivGuntingP1)
                        }
                        BATU -> {
                            bgChoosenImage(ivBatuP1)
                        }
                    }
                    bgChoosenImage(ivGuntingP2)
                    gameFunctionFriend(player1Choice, GUNTING)
                }
            }
            ivKertasP2.setOnClickListener {
                if (enemyType == getString(R.string.enemy_friend) && player1Choice != "DEFAULT") {
                    when (player1Choice) {
                        KERTAS -> {
                            bgChoosenImage(ivKertasP1)
                        }
                        GUNTING -> {
                            bgChoosenImage(ivGuntingP1)
                        }
                        BATU -> {
                            bgChoosenImage(ivBatuP1)
                        }
                    }
                    bgChoosenImage(ivKertasP2)
                    gameFunctionFriend(player1Choice, KERTAS)
                }
            }
            ivBatuP2.setOnClickListener {
                if (enemyType == getString(R.string.enemy_friend) && player1Choice != "DEFAULT") {
                    when (player1Choice) {
                        KERTAS -> {
                            bgChoosenImage(ivKertasP1)
                        }
                        GUNTING -> {
                            bgChoosenImage(ivGuntingP1)
                        }
                        BATU -> {
                            bgChoosenImage(ivBatuP1)
                        }
                    }
                    bgChoosenImage(ivBatuP2)
                    gameFunctionFriend(player1Choice, BATU)
                }
            }
            ivClose.setOnClickListener {
                backToMenu()
            }
        }
    }

    fun backToMenu() {
        finish()
    }

    fun resetState() {
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

    fun onClickPlayer1Choice(
        ivPlayerChoice: ImageView,
        choice: String,
        enemyType: String?
    ) {
        player1Choice = choice
        if (enemyType == getString(R.string.enemy_cpu)) {
            gameFunctionCpu(player1Choice)
            bgChoosenImage(ivPlayerChoice)
        } else {
            binding?.tvStatusPlayer?.text =
                String.format(getString(R.string.pemain_sedang_memilih, "2"))
        }
        blockClick()
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
        resultGame(mekanik.result(COM_CHOICE), getString(R.string.enemy_cpu), COM_CHOICE)
        showResultDialog()
        Log.d("RESULT", "Pemain 1 ${mekanik.result(COM_CHOICE)}")
    }

    fun bgChoosenImage(playerChoice: ImageView) {
        playerChoice.setBackgroundResource(BG_IMAGE)
    }

    fun gameFunctionFriend(player1Choice: String, player2Choice: String) {
        val mekanik = MekanikGameClass(player1Choice)
        resultGame(mekanik.result(player2Choice), getString(R.string.enemy_friend), player2Choice)
        showResultDialog()
        Log.d("RESULT", "Pemain 1 ${mekanik.result(player2Choice)}")
        Log.d("PLAYERCHOICE", "Pemain 1: $player1Choice, Pemain 2 : $player2Choice")
    }

    fun resultGame(result: String, enemyType: String, enemyAnswer: String) {
        val PLAYER1_WIN_TEXT: String = getString(R.string.player_1_win)
        val PLAYER2_WIN_TEXT: String = getString(R.string.player_2_win)
        val DRAW_TEXT: String = getString(R.string.draw_result)
        when (result) {
            WIN -> {
//                Toast.makeText(this, PLAYER1_WIN_TEXT, Toast.LENGTH_SHORT).show()
                Toast.makeText(this, String.format(getString(R.string.musuh_memilih), enemyType, enemyAnswer), Toast.LENGTH_SHORT).show()
                winner = intent.getStringExtra(USERNAME).toString()
            }
            DRAW -> {
//                Toast.makeText(this, DRAW_TEXT, Toast.LENGTH_SHORT).show()
                Toast.makeText(this, String.format(getString(R.string.musuh_memilih), enemyType, enemyAnswer), Toast.LENGTH_SHORT).show()
                winner = getString(R.string.draw_result)
            }
            else -> {
//                Toast.makeText(this, PLAYER2_WIN_TEXT, Toast.LENGTH_SHORT).show()
                Toast.makeText(this, String.format(getString(R.string.musuh_memilih), enemyType, enemyAnswer), Toast.LENGTH_SHORT).show()
                if (intent.getStringExtra(ENEMY_TYPE).toString() == getString(R.string.player_2)) {
                    winner = getString(R.string.player_2)
                } else {
                    winner = getString(R.string.player_2_friend)
                }
            }
        }
        Log.d("RESULT", "Pemain 1 ${result}")
    }

    fun showResultDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.layout_dialog_result)
        val width = ViewGroup.LayoutParams.MATCH_PARENT
        val height = ViewGroup.LayoutParams.WRAP_CONTENT
        dialog.window?.setLayout(width, height)
        dialog.setCancelable(true)

        val btnMainLagi = dialog.findViewById<Button>(R.id.btnMainLagi)
        val btnKembaliKeMenu = dialog.findViewById<Button>(R.id.btnKembaliKeMenu)
        val tvPemainPemenang = dialog.findViewById<TextView>(R.id.tvPemainPemenang)

        if (winner !== getString(R.string.draw_result)) {
            tvPemainPemenang.text = String.format(getString(R.string.pemain_menang), winner)
        } else {
            tvPemainPemenang.text = getString(R.string.draw_result)
        }

        btnMainLagi.setOnClickListener {
            resetState()
            dialog.dismiss()
        }

        btnKembaliKeMenu.setOnClickListener {
            backToMenu()
            dialog.dismiss()
        }
        dialog.show()
    }
}