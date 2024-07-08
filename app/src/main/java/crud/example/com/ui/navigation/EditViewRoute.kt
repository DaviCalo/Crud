package crud.example.com.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import crud.example.com.ui.screens.EditView

internal const val editScreenRoute = "EditView"

fun NavGraphBuilder.editViewNavigation(navController: NavHostController) {
    composable(editScreenRoute) {
        EditView(navController)
    }

    fun NavController.navEditView(navOptions: NavOptions? = null) {
        navigate(editScreenRoute, navOptions)
    }
}