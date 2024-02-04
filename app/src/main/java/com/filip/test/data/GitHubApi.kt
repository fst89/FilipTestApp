package com.filip.test.data

import com.filip.test.data.repository.repoDetails.models.RepoDetailsResponse
import com.filip.test.data.repository.tagList.models.RepoTagResponse
import com.filip.test.data.repository.userRepos.models.UserRepositoryResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubApi {

    @GET("/users/octocat/repos")
    suspend fun getGitHubUserRepositories(): List<UserRepositoryResponse>

    @GET("/repos/octocat/{repo}")
    suspend fun getRepoDetails(@Path("repo") repo: String): RepoDetailsResponse

    @GET("/repos/octocat/{repo}/tags")
    suspend fun getRepoTags(@Path("repo") repo: String): List<RepoTagResponse>
}