package com.example.crud.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.crud.ui.Views.HomeView


internal const val homeScreenRoute = "HomeScreen"

fun NavGraphBuilder.homeScreenNavigation(navController: NavHostController) {
    composable(homeScreenRoute) {
        HomeView(navController)
    }

    fun NavController.navToHomeScreen(navOptions: NavOptions? = null) {
        navigate(homeScreenRoute, navOptions)
    }
}