package com.filip.test.ui.screens.userRepoScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.filip.test.common.GitResult
import com.filip.test.domain.useCases.GetUserReposUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserRepoViewModel @Inject constructor(
    private val getUserReposUseCase: GetUserReposUseCase
) : ViewModel() {

    private val _userRepoUiState: MutableStateFlow<UserRepoStateHolder> = MutableStateFlow(UserRepoStateHolder.Loading)
    val userRepoUiState: StateFlow<UserRepoStateHolder> = _userRepoUiState.asStateFlow()

    init {
        getUserRepos()
    }

    private fun getUserRepos() {
        viewModelScope.launch {
            getUserReposUseCase.getUserRepos().collect { gitResult ->
                when (gitResult) {
                    is GitResult.Loading -> {
                        _userRepoUiState.value = UserRepoStateHolder.Loading
                    }

                    is GitResult.Error -> {
                        _userRepoUiState.value = UserRepoStateHolder.Error(error = "${gitResult.error.message}")
                    }

                    is GitResult.Success -> {
                        _userRepoUiState.value = UserRepoStateHolder.Success(gitResult.data)
                    }
                }
            }
        }
    }
}