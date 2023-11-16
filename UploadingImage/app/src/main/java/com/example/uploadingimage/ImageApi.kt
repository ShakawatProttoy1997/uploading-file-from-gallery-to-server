package com.example.uploadingimage

import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ImageApi {
    @Multipart
    @POST("v1/images/0XYvRd7oD")
    suspend fun uploadImage(
        @Part image: MultipartBody.Part
    ): ImageResponse
    companion object{
        val retrofitInstance by lazy{
            Retrofit.Builder().baseUrl("https://api.thecatapi.com/").addConverterFactory(GsonConverterFactory.create())
                .build().create(ImageApi::class.java)


        }
    }



}