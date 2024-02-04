package com.filip.test.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.filip.test.R
import com.filip.test.ui.theme.FilipTestAppTheme

@Composable
fun ErrorScreen(error: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.errorContainer),
        contentAlignment = Alignment.Center
    ) {
        Text(text = stringResource(id = R.string.error_message) + error, color = MaterialTheme.colorScheme.error, textAlign = TextAlign.Center)
    }
}

@Preview
@Composable
private fun ErrorScreenPreview() {
    FilipTestAppTheme {
        ErrorScreen(error = "404")
    }
}