package com.example.mvvmarchdemoapp.ui.screen

import com.example.mvvmarchdemoapp.domain.model.PostModel

data class PostState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val success: List<PostModel> = emptyList()
)
