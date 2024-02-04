package com.filip.test.data.repository.tagList.models

import com.filip.test.domain.models.RepoTag

data class RepoTagResponse(
    val commit: Commit,
    val name: String,
    val node_id: String,
    val tarball_url: String,
    val zipball_url: String
)

fun mapToTag(response: RepoTagResponse):RepoTag = RepoTag(
    name = response.name,
    sha = response.commit.sha
)