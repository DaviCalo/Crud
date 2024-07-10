package crud.example.com.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import crud.example.com.ui.screens.EditView

internal const val editScreenRoute = "EditView"

fun NavGraphBuilder.editViewNavigation(navController: NavHostController) {
    composable(
        route = "$editScreenRoute/{idTask}",
        arguments = listOf(navArgument("idTask") { type = NavType.StringType })
    ) { backStackEntry ->
        val id = backStackEntry.arguments?.getString("idTask")
        EditView(navController, id)
    }

    fun NavController.navEditView(navOptions: NavOptions? = null) {
        navigate(editScreenRoute, navOptions)
    }
}