package com.filip.test.ui.screens.repoDetailsScreen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.filip.test.ui.components.ErrorScreen
import com.filip.test.ui.components.LoadingScreen
import com.filip.test.ui.screens.repoDetailsScreen.components.RepoDetailsHeader
import com.filip.test.ui.screens.repoDetailsScreen.components.RepoDetailsList
import javax.inject.Inject

const val PATH_REPO_DETAILS = "repo_details"

@Composable
fun RepoDetailsScreen(repoName: String) {
    val viewModel: RepoDetailsViewModel = hiltViewModel()
    val repoDetailsStateHolder by viewModel.repoDetailsUiState.collectAsStateWithLifecycle()

    val rememberedRepoName by remember {
        mutableStateOf(repoName)
    }
    viewModel.repoName = rememberedRepoName
    LaunchedEffect(rememberedRepoName) {
        viewModel.getRepoDetails(rememberedRepoName)
    }

    when (repoDetailsStateHolder) {
        is RepoDetailsStateHolder.Loading -> {
            LoadingScreen()
        }

        is RepoDetailsStateHolder.Error -> {
            ErrorScreen(error = (repoDetailsStateHolder as RepoDetailsStateHolder.Error).error)
        }

        is RepoDetailsStateHolder.RepoDetailsSuccess -> {
            RepoDetailsList((repoDetailsStateHolder as RepoDetailsStateHolder.RepoDetailsSuccess).repoDetailsWithTags)
        }
    }
}