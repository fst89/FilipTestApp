package com.filip.test.ui.screens.repoDetailsScreen.components

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
import androidx.compose.ui.unit.dp
import com.filip.test.R
import com.filip.test.domain.models.RepoTag
import com.filip.test.domain.models.UserRepository

@Composable
fun RepoTagItem(repoTag: RepoTag) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxWidth()
            .padding(all = 10.dp)
    ) {
        TagName(name = repoTag.name)
        SHA(sha = repoTag.sha)
    }
}


@Composable
fun TagName(modifier: Modifier = Modifier, name: String) {
    Text(
        text = stringResource(id = R.string.tag_name_text, name),
        style = MaterialTheme.typography.titleLarge,
        color = MaterialTheme.colorScheme.primary
    )
}

@Composable
fun SHA(modifier: Modifier = Modifier, sha: String) {
    Text(
        style = MaterialTheme.typography.bodyLarge,
        color = MaterialTheme.colorScheme.secondary,
        text = stringResource(id = R.string.sha_text, sha)
    )
}