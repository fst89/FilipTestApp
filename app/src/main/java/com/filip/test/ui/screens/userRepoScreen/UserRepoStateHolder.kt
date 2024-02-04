package com.filip.test.ui.screens.userRepoScreen

import androidx.compose.runtime.mutableStateOf
import com.filip.test.domain.models.UserRepository

sealed interface UserRepoStateHolder {
    data object Loading : UserRepoStateHolder
    data class Error(val error: String) : UserRepoStateHolder
    data class Success(val userRepoList: List<UserRepository>) : UserRepoStateHolder
}