package com.mehmetaliozek.sudokusolver.data.service

import com.mehmetaliozek.sudokusolver.data.model.Sudoku
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface SudokuApiService {
    @Multipart
    @POST("solve")
    suspend fun uploadSudokuImage(@Part file: MultipartBody.Part): Response<Sudoku>
}