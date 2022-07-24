package com.rico.challenge4

import com.rico.challenge4.model.Choice.ChoiceAvaliable.BATU
import com.rico.challenge4.model.Choice.ChoiceAvaliable.GUNTING
import com.rico.challenge4.model.Choice.ChoiceAvaliable.KERTAS
import com.rico.challenge4.model.Result.ResultText.DRAW
import com.rico.challenge4.model.Result.ResultText.LOSE
import com.rico.challenge4.model.Result.ResultText.WIN

class MekanikGameClass(
    private var playerChoice: String
) {

    fun determiningComChoice(): String {
        val POSSIBLE_CHOICE = arrayListOf(
            KERTAS,
            BATU,
            GUNTING
        )
        return POSSIBLE_CHOICE.random()
    }

    fun result(comChoice: String): String {
        val REFRESH = "refresh"

        when (playerChoice) {
            GUNTING -> {
                when (comChoice) {
                    GUNTING -> return DRAW
                    KERTAS -> return WIN
                    BATU -> return LOSE
                }
            }
            KERTAS -> {
                when (comChoice) {
                    GUNTING -> return LOSE
                    KERTAS -> return DRAW
                    BATU -> return WIN
                }
            }
            BATU -> {
                when (comChoice) {
                    GUNTING -> return WIN
                    KERTAS -> return LOSE
                    BATU -> return DRAW
                }
            }
        }
        return REFRESH
    }
}