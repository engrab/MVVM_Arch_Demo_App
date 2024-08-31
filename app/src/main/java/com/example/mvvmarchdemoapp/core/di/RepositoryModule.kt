package com.example.mvvmarchdemoapp.core.di

import com.example.mvvmarchdemoapp.data.repositoryImp.PostRepositoryImp
import com.example.mvvmarchdemoapp.domain.repository.PostRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindPostRepository(postRepositoryImp: PostRepositoryImp): PostRepository
}