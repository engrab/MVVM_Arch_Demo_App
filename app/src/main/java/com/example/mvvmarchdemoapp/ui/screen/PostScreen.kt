package com.example.mvvmarchdemoapp.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mvvmarchdemoapp.domain.model.PostModel

@Composable
fun PostScreen(viewModel: PostViewModel = hiltViewModel()) {

    val postState by viewModel.postState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (postState.isLoading){

            CircularProgressIndicator()

        } else if (postState.error != null){
            Text(text = postState.error!!, fontSize = 30.sp)
        }else{
            LazyColumn {
                items(postState.success){
                    PostCard(it)
                }
            }
        }
    }



}

@Composable
fun PostCard(it: PostModel) {

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        Text(text = it.id.toString())
        Text(text = it.title)
        Text(text = it.body)

    }
}
