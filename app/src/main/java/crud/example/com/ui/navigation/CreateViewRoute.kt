package crud.example.com.ui.navigation


import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import crud.example.com.ui.view.CreateView
import crud.example.com.ui.view.DeleteView

internal const val createScreenRoute = "DeleteView"

fun NavGraphBuilder.createViewNavigation(navController: NavHostController) {
    composable(createScreenRoute) {
        CreateView(navController)
    }

    fun NavController.navToCreateView(navOptions: NavOptions? = null) {
        navigate(deleteScreenRoute, navOptions)
    }
}