package com.filip.test.domain.useCases

import com.filip.test.common.GitResult
import com.filip.test.data.repository.repoDetails.RepoDetailsInterface
import com.filip.test.data.repository.repoDetails.models.mapToRepoDetails
import com.filip.test.domain.models.RepoDetails
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetRepoDetailsUseCase @Inject constructor(private val repoDetailsRepository: RepoDetailsInterface) {
    fun getRepoDetails(repoName: String): Flow<GitResult<RepoDetails>> = flow {
        emit(GitResult.Loading())
        runCatching {
            repoDetailsRepository.getRepoDetails(repoName)
        }.mapCatching { repoDetailsResponse ->
            mapToRepoDetails(repoDetailsResponse)
        }.onSuccess { repoDetails ->
            emit(GitResult.Success(repoDetails))
        }.onFailure { throwable ->
            emit(GitResult.Error(throwable))
        }
    }
}