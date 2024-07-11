package crud.example.com

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import crud.example.com.ui.navigation.createViewNavigation
import crud.example.com.ui.navigation.editViewNavigation
import crud.example.com.ui.navigation.homeScreenNavigation
import crud.example.com.ui.navigation.homeScreenRoute

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
           App()
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = homeScreenRoute) {
        homeScreenNavigation(navController)
        createViewNavigation(navController)
        editViewNavigation(navController)
    }
}