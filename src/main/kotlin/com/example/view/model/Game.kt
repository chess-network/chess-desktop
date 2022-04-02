package com.example.view.model

data class Game(
    val id: String?,
    val stepNumber: Int? = 0,
    var whitePlayer: ChessPlayer?,
    var blackPlayer: ChessPlayer?,
    val messages: List<GameMessage>? = emptyList()
)