package com.example.mvvmarchdemoapp.data.repositoryImp

import com.example.mvvmarchdemoapp.data.api.PostApi
import com.example.mvvmarchdemoapp.data.mapper.toListPostModel
import com.example.mvvmarchdemoapp.domain.model.PostModel
import com.example.mvvmarchdemoapp.domain.repository.PostRepository
import javax.inject.Inject

class PostRepositoryImp @Inject constructor(private val postApi: PostApi): PostRepository {
    override suspend fun getPost(): List<PostModel> {
        return toListPostModel(postApi.getPost())
    }
}