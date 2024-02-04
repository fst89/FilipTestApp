package com.filip.test.ui.screens.repoDetailsScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.filip.test.R
import com.filip.test.domain.models.OwnerDetails
import com.filip.test.domain.models.RepoDetails
import com.filip.test.ui.theme.FilipTestAppTheme

@Composable
fun RepoDetailsHeader(repoDetails: RepoDetails) {
    Row(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
    ) {
        UserAvatar(
            repoDetails.ownerDetails.avatarUrl,
            modifier = Modifier.weight(1f),
        )
        RepoDetails(
            repoDetails,
            modifier = Modifier.weight(2f),
        )
    }
}

@Composable
fun UserAvatar(
    avatarUrl: String,
    modifier: Modifier = Modifier
) {
    AsyncImage(model = avatarUrl, contentDescription = "User Avatar")
}

@Composable
fun RepoDetails(
    repoDetails: RepoDetails,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = repoDetails.ownerDetails.name,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = repoDetails.name,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.secondary,
            textAlign = TextAlign.Center
        )
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                modifier = Modifier.weight(1f),
                text = stringResource(id = R.string.forks_text, repoDetails.numberOfForks),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.secondary,
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier.weight(1f),
                text = stringResource(id = R.string.watchers_text, repoDetails.numberOfWatchers),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.secondary,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
fun RepoDetailsPreview() {
    FilipTestAppTheme {
        RepoDetails(
            RepoDetails(
                "filip repo",
                2,
                3,
                OwnerDetails(
                    "Filip",
                    ""
                )
            )
        )
    }
}