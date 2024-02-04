package com.filip.test.data.repository.repoDetails

import com.filip.test.data.repository.repoDetails.models.RepoDetailsResponse
import com.filip.test.data.repository.tagList.models.RepoTagResponse

interface RepoDetailsInterface {
    suspend fun getRepoDetails(repoName: String): RepoDetailsResponse
    suspend fun getRepoTags(repoName: String): List<RepoTagResponse>
}