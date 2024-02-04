package com.filip.test.domain.useCases

import android.util.Log
import com.filip.test.common.GitResult
import com.filip.test.data.repository.userRepos.UserRepositoryInterface
import com.filip.test.domain.models.UserRepository
import com.filip.test.data.repository.userRepos.models.mapToUserRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetUserReposUseCase @Inject constructor(private val userReposRepository: UserRepositoryInterface) {
    fun getUserRepos(): Flow<GitResult<List<UserRepository>>> = flow {
        emit(GitResult.Loading())
        runCatching {
            userReposRepository.getUserRepositories()
        }.mapCatching { userReposResponseList ->
            userReposResponseList.map { userReposResponse ->
                mapToUserRepository(userReposResponse)
            }
        }.onSuccess {
            emit(GitResult.Success(it))
        }.onFailure { throwable ->
            emit(GitResult.Error(throwable))
        }
    }
}