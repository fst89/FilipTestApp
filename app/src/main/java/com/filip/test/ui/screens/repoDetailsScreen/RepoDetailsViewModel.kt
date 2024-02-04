package com.filip.test.ui.screens.repoDetailsScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.filip.test.domain.useCases.GetRepoDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.filip.test.common.GitResult
import com.filip.test.domain.models.RepoDetailsWithTags
import com.filip.test.domain.useCases.GetRepoTagsUseCase
import kotlinx.coroutines.flow.combine
import java.lang.IllegalStateException

@HiltViewModel
class RepoDetailsViewModel @Inject constructor(
    private val getRepoDetailsUseCase: GetRepoDetailsUseCase,
    private val getRepoTagsUseCase: GetRepoTagsUseCase
) : ViewModel() {
    private val _repoDetailsUiState: MutableStateFlow<RepoDetailsStateHolder> =
        MutableStateFlow(RepoDetailsStateHolder.Loading)
    val repoDetailsUiState: StateFlow<RepoDetailsStateHolder> = _repoDetailsUiState.asStateFlow()

    var repoName: String = ""

    fun getRepoDetails(repoName: String) {
        viewModelScope.launch {
            getRepoDetailsUseCase.getRepoDetails(repoName)
                .combine(getRepoTagsUseCase.getRepoTags(repoName)) { detailsResult, tagsResult ->
                    when {
                        detailsResult is GitResult.Loading || tagsResult is GitResult.Loading -> {
                            RepoDetailsStateHolder.Loading
                        }

                        detailsResult is GitResult.Error || tagsResult is GitResult.Error -> {
                            RepoDetailsStateHolder.Error(
                                "${(detailsResult as GitResult.Error).error}\n" +
                                        "${(tagsResult as GitResult.Error).error}"
                            )
                        }

                        detailsResult is GitResult.Success && tagsResult is GitResult.Success -> {
                            RepoDetailsStateHolder.RepoDetailsSuccess(
                                RepoDetailsWithTags(
                                    detailsResult.data,
                                    tagsResult.data
                                )
                            )
                        }

                        else -> {
                            throw IllegalStateException("Unexpected result")
                        }
                    }
                }
                .collect { repoDetailsResult ->
                    when (repoDetailsResult) {
                        is RepoDetailsStateHolder.Loading -> _repoDetailsUiState.value =
                            RepoDetailsStateHolder.Loading
                        is RepoDetailsStateHolder.Error -> _repoDetailsUiState.value = RepoDetailsStateHolder.Loading
                        is RepoDetailsStateHolder.RepoDetailsSuccess -> _repoDetailsUiState.value =
                            RepoDetailsStateHolder.RepoDetailsSuccess(repoDetailsResult.repoDetailsWithTags)
                    }
                    /* when (repoDetailsResult) {
                         is GitResult.Loading -> {
                             _repoDetailsUiState.value = RepoDetailsStateHolder.Loading
                         }

                         is GitResult.Success -> {
                             _repoDetailsUiState.value =
                                 RepoDetailsStateHolder.RepoDetailsSuccess(repoDetailsResult.data)
                         }

                         is GitResult.Error -> {
                             _repoDetailsUiState.value =
                                 RepoDetailsStateHolder.Error("${repoDetailsResult.error.message}")
                         }

                         else -> {}
                     }*/
                }
        }
    }
}
