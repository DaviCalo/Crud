package crud.example.com.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import crud.example.com.ui.components.TabBar
import crud.example.com.ui.theme.CRUDTheme

@Composable
fun DeleteView(navController: NavController) {
    CRUDTheme {
        Scaffold(
            topBar = { },
            bottomBar = { TabBar(navController = navController, screen = 3) }
        ) { innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding)
            ) {
                println("home3")
            }
        }
    }
}
//
//@Preview(
//    showBackground = true,
//    uiMode = Configuration.UI_MODE_NIGHT_NO,
//    name = "Default Preview Dark"
//)
//@Composable
//fun PreviewDelete(){
//    val navController = rememberNavController()
//    DeleteView(navController)
//}