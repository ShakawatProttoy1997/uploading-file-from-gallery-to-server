package com.example.uploadingimage

import androidx.lifecycle.ViewModel
import okhttp3.ResponseBody
import retrofit2.Call
import java.io.File
import java.io.InputStream

class ImageViewModel(private  val repository: ImageRepository = ImageRepository()):ViewModel() {
   // fun uploadImage(imageFile: File): Call<ResponseBody> {
      //  return repository.uploadImage(imageFile)
   // }
}