package com.filip.test.ui.screens.userRepoScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.filip.test.R
import com.filip.test.domain.models.UserRepository
import com.filip.test.ui.theme.FilipTestAppTheme

@Composable
fun UserRepoItem(userRepo: UserRepository, onItemClick: (UserRepository) -> Unit) {
    Column(modifier = Modifier
        .background(MaterialTheme.colorScheme.background)
        .fillMaxWidth()
        .padding(all = 10.dp)
        .clickable { onItemClick(userRepo) }) {
        UserRepoName(name = userRepo.name)
        UserRepoIssues(numberOfIssues = userRepo.openedIssuesCount)
    }
}


@Composable
fun UserRepoName(modifier: Modifier = Modifier, name: String) {
    Text(
        text = name,
        style = MaterialTheme.typography.titleLarge,
        color = MaterialTheme.colorScheme.primary
    )
}

@Composable
fun UserRepoIssues(modifier: Modifier = Modifier, numberOfIssues: Int) {
    Text(
        style = MaterialTheme.typography.bodyLarge,
        color = MaterialTheme.colorScheme.secondary,
        text = if (numberOfIssues == 1)
            stringResource(id = R.string.opened_issue, numberOfIssues)
        else
            stringResource(id = R.string.opened_issues, numberOfIssues)
    )
}

@Preview
@Composable
fun UserRepoNamePreview() {
    FilipTestAppTheme {
        UserRepoItem(UserRepository("prvi repo", 1), {})
    }
}