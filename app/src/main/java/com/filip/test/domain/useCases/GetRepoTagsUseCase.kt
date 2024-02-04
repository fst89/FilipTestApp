package com.filip.test.domain.useCases

import com.filip.test.common.GitResult
import com.filip.test.data.repository.repoDetails.RepoDetailsInterface
import com.filip.test.data.repository.tagList.models.mapToTag
import com.filip.test.domain.models.RepoTag
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetRepoTagsUseCase @Inject constructor(
    private val repoDetailsRepository: RepoDetailsInterface
) {
    fun getRepoTags(repoName: String): Flow<GitResult<List<RepoTag>>> = flow {
        emit(GitResult.Loading())
        runCatching {
            repoDetailsRepository.getRepoTags(repoName)
        }.mapCatching { repoDetailsResponse ->
            repoDetailsResponse.map { repoTagResponse ->
                mapToTag(repoTagResponse)
            }
        }.onSuccess {
            emit(GitResult.Success(it))
        }.onFailure {
            emit(GitResult.Error(it))
        }
    }
}