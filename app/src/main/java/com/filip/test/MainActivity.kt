package com.filip.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.filip.test.ui.navigation.Navigation
import com.filip.test.ui.theme.FilipTestAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FilipTestAppTheme {
                GitHubApp()
            }
        }
    }

    @Composable
    fun GitHubApp(modifier: Modifier = Modifier) {
        val navController = rememberNavController()
        Navigation(navController = navController)
    }
}

