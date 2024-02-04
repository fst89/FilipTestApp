package com.filip.test.domain.models

class RepoDetailsWithTags(
    val repoDetails: RepoDetails,
    val repoTagList: List<RepoTag>? = emptyList()
)