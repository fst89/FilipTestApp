package com.filip.test.ui.screens.userRepoScreen.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.filip.test.domain.models.UserRepository
import com.filip.test.ui.theme.FilipTestAppTheme
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme

@Composable
fun UserRepoList(
    userRepositoryList: List<UserRepository>,
    onRepoClick: (UserRepository) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        items(userRepositoryList) { item ->
            UserRepoItem(userRepo = item, onItemClick = onRepoClick)
            Divider(color = MaterialTheme.colorScheme.onBackground)
        }
    }
}

@Preview
@Composable
fun UserRepoScreenPreview() {
    FilipTestAppTheme {
        UserRepoList(
            listOf(
                UserRepository("test 1", 0),
                UserRepository("test 2", 4)
            ), {})
    }
}