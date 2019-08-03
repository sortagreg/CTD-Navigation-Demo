package com.example.ctdnavigagtiondemo.rockpaperscissors

fun getWinner(
    playerChoice: RPS,
    computerChoice: RPS
): RPSResult = when {
    playerChoice == computerChoice -> RPSResult.TIE
    playerChoice.ordinal == (computerChoice.ordinal + 1) % 3 -> RPSResult.PLAYER_WIN
    else -> RPSResult.COMPUTER_WIN
}

fun getComputerChoice(): RPS = arrayOf(
    RPS.ROCK,
    RPS.PAPER,
    RPS.SCISSORS
).random()
