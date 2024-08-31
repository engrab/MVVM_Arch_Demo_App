package com.example.mvvmarchdemoapp.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmarchdemoapp.core.common.Response
import com.example.mvvmarchdemoapp.domain.usecase.PostUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(private val postUseCase: PostUseCase): ViewModel() {


    private var _postState = MutableStateFlow(PostState())
    val postState = _postState.asStateFlow()

    init {
        getPost()
    }

    private fun getPost() {

        viewModelScope.launch(Dispatchers.IO){
            postUseCase().collect{
                when(it){
                    is Response.Error -> {
                        _postState.value = PostState(error = it.errorMessage)
                    }
                    Response.Loading -> {
                        _postState.value = PostState(isLoading = true)
                    }
                    is Response.Success -> {
                        _postState.value = PostState(success = it.data)
                    }
                }
            }
        }
    }

}