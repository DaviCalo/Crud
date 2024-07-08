package crud.example.com.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import crud.example.com.ui.screens.EditView
import kotlinx.serialization.Serializable

@Serializable
object EditScreenRoute

fun NavGraphBuilder.editViewNavigation(navController: NavHostController) {
    composable<EditScreenRoute> {
        EditView(navController)
    }
}