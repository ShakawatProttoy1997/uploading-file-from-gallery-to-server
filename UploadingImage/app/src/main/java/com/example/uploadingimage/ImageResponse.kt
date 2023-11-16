package com.example.uploadingimage

data class ImageResponse(
    var breeds: List<Breed>,
    var height: Int,
    var id: String,
    var url: String,
    var width: Int
)