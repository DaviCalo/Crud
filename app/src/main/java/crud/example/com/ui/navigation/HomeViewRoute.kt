package crud.example.com.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import crud.example.com.ui.screens.HomeView
import kotlinx.serialization.Serializable

@Serializable
object HomeScreenRoute

fun NavGraphBuilder.homeScreenNavigation(navController: NavHostController) {
    composable<HomeScreenRoute> {
        HomeView(navController)
    }

}