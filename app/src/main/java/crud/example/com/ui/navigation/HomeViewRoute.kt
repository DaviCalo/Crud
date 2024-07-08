package crud.example.com.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import crud.example.com.ui.screens.HomeView

internal const val homeScreenRoute = "HomeScreen"

fun NavGraphBuilder.homeScreenNavigation(navController: NavHostController) {
    composable(homeScreenRoute) {
        HomeView(navController)
    }

}