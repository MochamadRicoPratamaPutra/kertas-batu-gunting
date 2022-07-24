package com.rico.challenge4

import com.rico.challenge4.model.choice
import com.rico.challenge4.model.choice.choiceAvaliable.BATU
import com.rico.challenge4.model.choice.choiceAvaliable.GUNTING
import com.rico.challenge4.model.choice.choiceAvaliable.KERTAS
import com.rico.challenge4.model.result

class MekanikGameClass(
    var playerChoice: String
) {

    fun determiningComChoice(): String {
        val possibleChoice = arrayListOf<String>(
            KERTAS,
            BATU,
            GUNTING
        )
        return possibleChoice.random()
    }

    fun result(comChoice: String): String {
        val REFRESH = "refresh"

        if (playerChoice == GUNTING) {
            when (comChoice) {
                GUNTING -> return result.resultText.DRAW
                KERTAS -> return result.resultText.WIN
                BATU -> return result.resultText.LOSE
            }
        } else if (playerChoice == KERTAS) {
            when (comChoice) {
                GUNTING -> return result.resultText.LOSE
                KERTAS -> return result.resultText.DRAW
                BATU -> return result.resultText.WIN
            }
        } else if (playerChoice == BATU) {
            when (comChoice) {
                GUNTING -> return result.resultText.WIN
                KERTAS -> return result.resultText.LOSE
                BATU -> return result.resultText.DRAW
            }
        }
        return REFRESH
    }
}