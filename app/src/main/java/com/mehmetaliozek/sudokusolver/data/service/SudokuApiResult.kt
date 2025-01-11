package com.mehmetaliozek.sudokusolver.data.service

sealed class SudokuApiResult<out T>() {
    data class Success<out T>(val data: T) : SudokuApiResult<T>()
    data class Error(val errorMessage: String) : SudokuApiResult<Nothing>()
}