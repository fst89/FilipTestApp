package com.filip.test.ui.screens.repoDetailsScreen.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.filip.test.domain.models.RepoDetailsWithTags

@Composable
fun RepoDetailsList(repoDetailsWithTags: RepoDetailsWithTags) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            RepoDetailsHeader(repoDetails = repoDetailsWithTags.repoDetails)
        }
        repoDetailsWithTags.repoTagList?.let { list ->
            items(list) { tag ->
                RepoTagItem(tag)
            }
        }
    }
}