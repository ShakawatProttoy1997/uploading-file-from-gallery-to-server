package com.example.uploadingimage

import android.net.Uri
import android.os.Bundle
import android.util.Log.d
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {

   // lateinit var viewModel: ImageViewModel
    lateinit var imageView:ImageView
    lateinit var newBtn:Button
    lateinit var uploadBtn:Button
    var imageUri:Uri? = null
    private val contract = registerForActivityResult(ActivityResultContracts.GetContent()){
        imageUri = it!!
        imageView.setImageURI(it)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_layout)
       setUp()

    }

    private fun setUp() {
        imageView = findViewById(R.id.imageView)
        newBtn = findViewById(R.id.changeBtn)
        newBtn.setOnClickListener{contract.launch("image/*")}
        uploadBtn = findViewById(R.id.uploadBtn)
        uploadBtn.setOnClickListener{upload()}
    }

    private fun upload() {
        val fileDir = application.filesDir
        val file = File(fileDir,"ryogas_banner.png")
        val inputStream = imageUri?.let { contentResolver.openInputStream(it) }
        val outputStream = FileOutputStream(file)
        inputStream!!.copyTo(outputStream)
        val requestBody = file.asRequestBody("image/*".toMediaTypeOrNull())
        val part = MultipartBody.Part.createFormData("x-amz-meta-image_id",file.name, requestBody)
        val retrofit = ImageApi.retrofitInstance
        CoroutineScope(Dispatchers.IO).launch {
            val response = retrofit.uploadImage(part)
            d("response: ",response.toString())
        }

    }
}

