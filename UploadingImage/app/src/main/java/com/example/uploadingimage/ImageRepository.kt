package com.example.uploadingimage

import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.HttpException
import java.io.File
import java.io.IOException

class ImageRepository{
   /* private val apiService: ImageApi.Companion = ImageApi // Initialize Retrofit and create ApiService

    fun uploadImage(imageFile: File): Call<ResponseBody> {
        val requestFile = RequestBody.create("multipart/form-data".toMediaTypeOrNull(), imageFile)
        val imagePart = MultipartBody.Part.createFormData("ryogas_banner.png", imageFile.name, requestFile)

        return apiService.retrofitInstance.uploadImage(imagePart)
    }

    */
}