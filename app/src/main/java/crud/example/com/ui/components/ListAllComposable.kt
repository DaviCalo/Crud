package crud.example.com.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavController
import crud.example.com.ui.navigation.editScreenRoute
import crud.example.com.ui.viewmodels.HomeViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun ListAll(navController: NavController, select: Int){
    val viewModel = koinViewModel<HomeViewModel>()
    val scope = rememberCoroutineScope()
    if (viewModel.listAll != null){
        viewModel.listAll?.forEachIndexed() { _, todo ->
            if (todo.status == viewModel.listStatus[select-1]){
                CardTodo(
                    todo.title,
                    todo.description,
                    todo.status,
                    todo.data,
                    todo.time,
                    { navController.navigate("$editScreenRoute/${todo.id}") },
                    { scope.launch{viewModel.delete(todo.id)} }
                )
            }
        }
    }
}