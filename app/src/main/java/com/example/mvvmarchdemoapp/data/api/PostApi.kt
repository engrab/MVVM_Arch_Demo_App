package com.example.mvvmarchdemoapp.data.api

import com.example.mvvmarchdemoapp.data.dto.PostDTO
import retrofit2.http.GET

interface PostApi {

    @GET("posts")
    suspend fun getPost(): List<PostDTO>
}