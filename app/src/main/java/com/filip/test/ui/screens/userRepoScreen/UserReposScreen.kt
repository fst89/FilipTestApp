package com.filip.test.ui.screens.userRepoScreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.filip.test.ui.components.ErrorScreen
import com.filip.test.ui.components.LoadingScreen
import com.filip.test.ui.screens.userRepoScreen.components.UserRepoList

const val PATH_USER_REPOS = "user_repos"

@Composable
fun UserReposScreen(
    onNavigateToRepoDetails: (String) -> Unit,
) {
    val viewModel: UserRepoViewModel = hiltViewModel()
    val userRepoStateHolder by viewModel.userRepoUiState.collectAsStateWithLifecycle()

    when (userRepoStateHolder) {
        is UserRepoStateHolder.Error -> ErrorScreen(error = (userRepoStateHolder as UserRepoStateHolder.Error).error)
        is UserRepoStateHolder.Loading -> LoadingScreen()
        is UserRepoStateHolder.Success -> UserRepoList(
            userRepositoryList = (userRepoStateHolder as UserRepoStateHolder.Success).userRepoList,
            onRepoClick = {
                onNavigateToRepoDetails(it.name)
            })
    }
}