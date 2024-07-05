package crud.example.com.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import crud.example.com.ui.view.DeleteView

internal const val deleteScreenRoute = "DeleteView"

fun NavGraphBuilder.deleteViewNavigation(navController: NavHostController) {
    composable(deleteScreenRoute) {
        DeleteView(navController)
    }

    fun NavController.navToDeleteView(navOptions: NavOptions? = null) {
        navigate(deleteScreenRoute, navOptions)
    }
}