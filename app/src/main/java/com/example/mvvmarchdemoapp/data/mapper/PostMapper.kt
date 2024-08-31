package com.example.mvvmarchdemoapp.data.mapper

import com.example.mvvmarchdemoapp.data.dto.PostDTO
import com.example.mvvmarchdemoapp.domain.model.PostModel

fun toPostModel(postDTO: PostDTO): PostModel{

    return PostModel(
        body = postDTO.body,
        id = postDTO.id,
        title = postDTO.title
    )
}

fun toListPostModel(list: List<PostDTO>): List<PostModel>{

    return list.map {
        toPostModel(it)
    }
}