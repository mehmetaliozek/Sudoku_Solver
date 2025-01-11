package com.mehmetaliozek.sudokusolver.data.model

import com.google.gson.annotations.SerializedName

data class Sudoku(
    val solution: List<Int>,
    @SerializedName("solved_numbers")
    val solvedNumbers: List<Int>
)
