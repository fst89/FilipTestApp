package com.filip.test.data.repository.repoDetails

import com.filip.test.data.GitHubApi
import com.filip.test.data.repository.repoDetails.models.RepoDetailsResponse
import com.filip.test.data.repository.tagList.models.RepoTagResponse
import javax.inject.Inject

class RepoDetailsImplementation @Inject constructor(
    private val gitHubApi: GitHubApi
) : RepoDetailsInterface {
    override suspend fun getRepoDetails(repoName: String): RepoDetailsResponse = gitHubApi.getRepoDetails(repoName)
    override suspend fun getRepoTags(repoName: String): List<RepoTagResponse> = gitHubApi.getRepoTags(repoName)
}