package ui.test

import com.example.unscramble.ui.GameViewModel
import data.SCORE_INCREASE
import data.getUnscrambledWord
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Assert.assertNotEquals
import org.junit.Test

class GameViewModelTest {

    private val viewModel = GameViewModel()

    @Test
    fun gameViewModel_Initialization_FirstWordLoaded() {
        var currentGameUiState = viewModel.uiState.value
        val unScrambledWord  = getUnscrambledWord(currentGameUiState.currentScrambledWord)

        viewModel.updateUserGuess(unScrambledWord )
        viewModel.checkUserGuess()

        currentGameUiState = viewModel.uiState.value
        assertTrue(currentGameUiState.isGuessedWordWrong)
        assertEquals(0, currentGameUiState.score)
        assertNotEquals(unScrambledWord,currentGameUiState.currentScrambledWord)



    }

    @Test
    fun gameViewModel_IncorrectGuess_ErrorFlagSet() {
        val incorrectPlayerWord = "and"
        var currentGameUiState = viewModel.uiState.value

        viewModel.updateUserGuess(incorrectPlayerWord)
        viewModel.checkUserGuess()

        assertEquals(0,currentGameUiState.score)
        assertFalse(currentGameUiState.isGuessedWordWrong)

    }

    companion object {
        private const val SCORE_AFTER_FIRST_CORRECT_ANSWER = SCORE_INCREASE
    }
}