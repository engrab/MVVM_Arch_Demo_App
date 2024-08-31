package com.example.mvvmarchdemoapp.domain.repository

import com.example.mvvmarchdemoapp.domain.model.PostModel

interface PostRepository {

    suspend fun getPost(): List<PostModel>
}