package com.filip.test.data.repository.userRepos.models

import com.filip.test.domain.models.OwnerDetails
import com.google.gson.annotations.SerializedName

data class Owner(
    @SerializedName("avatar_url")
    val avatarUrl: String,
    val events_url: String,
    val followers_url: String,
    val following_url: String,
    val gists_url: String,
    val gravatar_id: String,
    val html_url: String,
    val id: Int,
    @SerializedName("login")
    val name: String,
    val node_id: String,
    val organizations_url: String,
    val received_events_url: String,
    val repos_url: String,
    val site_admin: Boolean,
    val starred_url: String,
    val subscriptions_url: String,
    val type: String,
    val url: String
)

fun mapToOwnerDetails(response: Owner): OwnerDetails =
    OwnerDetails(
        name = response.name,
        avatarUrl = response.avatarUrl
    )