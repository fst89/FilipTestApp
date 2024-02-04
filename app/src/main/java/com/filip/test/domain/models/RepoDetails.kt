package com.filip.test.domain.models

data class RepoDetails(
    val name: String,
    val numberOfForks: Int,
    val numberOfWatchers: Int,
    val ownerDetails: OwnerDetails
)

