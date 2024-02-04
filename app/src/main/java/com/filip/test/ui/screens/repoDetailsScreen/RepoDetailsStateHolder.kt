package com.filip.test.ui.screens.repoDetailsScreen

import com.filip.test.domain.models.RepoDetailsWithTags

sealed interface RepoDetailsStateHolder {
    data object Loading : RepoDetailsStateHolder
    data class Error(val error: String) : RepoDetailsStateHolder
    data class RepoDetailsSuccess(val repoDetailsWithTags: RepoDetailsWithTags) : RepoDetailsStateHolder

}