package com.example.mvvmarchdemoapp.domain.usecase

import com.example.mvvmarchdemoapp.core.common.Response
import com.example.mvvmarchdemoapp.domain.model.PostModel
import com.example.mvvmarchdemoapp.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PostUseCase @Inject constructor(private val postRepository: PostRepository) {

    suspend operator fun invoke(): Flow<Response<List<PostModel>>> = flow {


        try {

            emit(Response.Loading)

            emit(Response.Success(data = postRepository.getPost()))

        }catch (e: Exception){
            emit(Response.Error(errorMessage = e.message.toString()))
        }


    }
}