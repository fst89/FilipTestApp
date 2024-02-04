package com.filip.test.di

import com.filip.test.common.BASE_URL
import com.filip.test.data.GitHubApi
import com.filip.test.data.repository.repoDetails.RepoDetailsImplementation
import com.filip.test.data.repository.repoDetails.RepoDetailsInterface
import com.filip.test.data.repository.userRepos.UserRepositoryImplementation
import com.filip.test.data.repository.userRepos.UserRepositoryInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class HiltModule {

    @Provides
    @Singleton
    fun provideGithubApi(): GitHubApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(GitHubApi::class.java)

    @Provides
    @Singleton
    fun provideUserReposRepository(api: GitHubApi): UserRepositoryInterface = UserRepositoryImplementation(api)

    @Provides
    @Singleton
    fun provideRepoDetailsRepository(api: GitHubApi): RepoDetailsInterface = RepoDetailsImplementation(api)

}