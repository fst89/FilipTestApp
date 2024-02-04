package com.filip.test.ui.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.filip.test.ui.screens.repoDetailsScreen.PATH_REPO_DETAILS
import com.filip.test.ui.screens.userRepoScreen.PATH_USER_REPOS
import com.filip.test.ui.screens.repoDetailsScreen.RepoDetailsScreen
import com.filip.test.ui.screens.userRepoScreen.UserReposScreen
import java.io.File

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = PATH_USER_REPOS) {
        composable(PATH_USER_REPOS) {
            UserReposScreen(onNavigateToRepoDetails = { path ->
                navController.navigate(
                    PATH_REPO_DETAILS + File.separator + path
                )
            })
        }
        composable("$PATH_REPO_DETAILS/{repository}") { navBackStackEntry ->
            val repoName = navBackStackEntry.arguments?.getString("repository")
            RepoDetailsScreen(repoName ?: "")
        }
    }
}