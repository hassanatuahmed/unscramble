package com.example.unscramble.ui.GameUiState

data class GameUiState (
    val currentWordCount : Int =1,
    val isGameOver: Boolean = false,
    val currentScrambledWord: String = "",
    val isGuessedWordWrong : Boolean = false,
    val score:Int = 0 )