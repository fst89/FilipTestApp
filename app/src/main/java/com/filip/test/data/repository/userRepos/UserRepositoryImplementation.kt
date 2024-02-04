package com.filip.test.data.repository.userRepos

import com.filip.test.data.GitHubApi
import com.filip.test.data.repository.userRepos.models.UserRepositoryResponse
import javax.inject.Inject

class UserRepositoryImplementation @Inject constructor(
    private val gitHubApi: GitHubApi
) : UserRepositoryInterface {
    override suspend fun getUserRepositories(): List<UserRepositoryResponse> = gitHubApi.getGitHubUserRepositories()
}