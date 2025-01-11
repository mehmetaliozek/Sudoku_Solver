package com.mehmetaliozek.sudokusolver.data.repository

import android.content.Context
import android.net.Uri
import com.google.gson.Gson
import com.mehmetaliozek.sudokusolver.data.model.ErrorResponse
import com.mehmetaliozek.sudokusolver.data.model.Sudoku
import com.mehmetaliozek.sudokusolver.data.service.RetrofitInstance
import com.mehmetaliozek.sudokusolver.data.service.SudokuApiResult
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

class SudokuRepository {
    private val sudokuApiService = RetrofitInstance.sudokuApiService

    suspend fun uploadSudokuImageToApi(imageUri: Uri, context: Context): SudokuApiResult<Sudoku?> {
        val contentResolver = context.contentResolver
        val inputStream = contentResolver.openInputStream(imageUri)
            ?: return SudokuApiResult.Error("Image could not be opened")
        val file = File(context.cacheDir, "sudoku_image.jpg")
        val outputStream = file.outputStream()
        inputStream.copyTo(outputStream)

        val requestFile = RequestBody.create(MediaType.parse("image/*"), file)
        val body = MultipartBody.Part.createFormData("file", file.name, requestFile)

        val response = sudokuApiService.uploadSudokuImage(body)
        return if (response.isSuccessful) {
            val sudoku = response.body()
            if (sudoku != null) {
                SudokuApiResult.Success(sudoku)
            } else {
                SudokuApiResult.Error("Empty response returned")
            }
        } else {
            val errorBody = response.errorBody()?.string()
            val errorResponse = errorBody?.let {
                try {
                    Gson().fromJson(it, ErrorResponse::class.java)
                } catch (e: Exception) {
                    null
                }
            }
            SudokuApiResult.Error(errorResponse!!.error)
        }
    }
}