package crud.example.com.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import crud.example.com.ui.screens.CreateView

internal const val createScreenRoute = "CreateView"

fun NavGraphBuilder.createViewNavigation(navController: NavHostController) {
    composable(createScreenRoute) {
        CreateView(navController)
    }

    fun NavController.navToCreateView(navOptions: NavOptions? = null) {
        navigate(createScreenRoute, navOptions)
    }
}
