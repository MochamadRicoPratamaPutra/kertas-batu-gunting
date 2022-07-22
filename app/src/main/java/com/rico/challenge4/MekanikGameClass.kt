package com.rico.challenge4

class MekanikGameClass(
    var playerChoice: String,
    var comChoice: String
) {
    fun result(): String {
        val GUNTING = "gunting"
        val KERTAS = "kertas"
        val BATU = "batu"

        val WIN = "win"
        val LOSE = "lose"
        val DRAW = "draw"

        val REFRESH = "refresh"

        if (playerChoice == GUNTING) {
            when (comChoice) {
                GUNTING -> return DRAW
                KERTAS -> return WIN
                BATU -> return LOSE
            }
        } else if (playerChoice == KERTAS) {
            when (comChoice) {
                GUNTING -> return LOSE
                KERTAS -> return DRAW
                BATU -> return WIN
            }
        } else if (playerChoice == BATU) {
            when (comChoice) {
                GUNTING -> return WIN
                KERTAS -> return LOSE
                BATU -> return DRAW
            }
        }
        return REFRESH
    }
}