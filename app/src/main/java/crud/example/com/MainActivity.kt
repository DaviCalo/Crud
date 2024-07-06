package crud.example.com

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import crud.example.com.ui.navigation.createScreenRoute
import crud.example.com.ui.navigation.createViewNavigation
import crud.example.com.ui.navigation.deleteScreenRoute
import crud.example.com.ui.navigation.deleteViewNavigation
import crud.example.com.ui.navigation.editScreenRoute
import crud.example.com.ui.navigation.editViewNavigation
import crud.example.com.ui.navigation.homeScreenNavigation
import crud.example.com.ui.navigation.homeScreenRoute
import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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
        deleteViewNavigation(navController)
    }
}