package com.mehmetaliozek.sudokusolver.viewmodel

import android.content.Context
import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mehmetaliozek.sudokusolver.data.model.Sudoku
import com.mehmetaliozek.sudokusolver.data.repository.SudokuRepository
import com.mehmetaliozek.sudokusolver.data.service.SudokuApiResult
import kotlinx.coroutines.launch

class SudokuViewModel : ViewModel() {
    private val repository = SudokuRepository()

    private val _sudoku = MutableLiveData<Sudoku?>()
    val sudoku: LiveData<Sudoku?> get() = _sudoku

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> get() = _errorMessage

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    fun solve(imageUri: Uri, context: Context) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                when (val result = repository.uploadSudokuImageToApi(imageUri, context)) {
                    is SudokuApiResult.Success -> handleSuccess(result)
                    is SudokuApiResult.Error -> handleError(result.errorMessage)
                }
            } catch (e: Exception) {
                handleError("Unexpected error occurred: ${e.localizedMessage}")
            } finally {
                _isLoading.value = false
            }
        }
    }

    private fun handleSuccess(result: SudokuApiResult.Success<Sudoku?>) {
        _sudoku.value = result.data
        _errorMessage.value = null
    }

    private fun handleError(message: String) {
        _sudoku.value = null
        _errorMessage.value = message
    }

    fun reset() {
        _sudoku.value = null
        _errorMessage.value = null
        _isLoading.value = false
    }
}