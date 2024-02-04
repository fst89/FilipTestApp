package com.filip.test.data.repository.userRepos

import com.filip.test.data.repository.userRepos.models.UserRepositoryResponse

interface UserRepositoryInterface {
    suspend fun getUserRepositories(): List<UserRepositoryResponse>
}