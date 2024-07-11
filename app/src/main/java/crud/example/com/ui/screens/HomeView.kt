package crud.example.com.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.crud.R
import crud.example.com.ui.components.CardTodo
import crud.example.com.ui.components.DialogSearch
import crud.example.com.ui.components.ExtendedActionButton
import crud.example.com.ui.components.NavBar
import crud.example.com.ui.components.TabBar
import crud.example.com.ui.navigation.createScreenRoute
import crud.example.com.ui.navigation.editScreenRoute
import crud.example.com.ui.theme.CRUDTheme
import crud.example.com.ui.viewmodels.HomeViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeView(navController: NavController){
    val viewModel = koinViewModel<HomeViewModel>()
    val scope = rememberCoroutineScope()
    CRUDTheme {
        Scaffold(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .systemBarsPadding(),
            topBar = { TabBar(){ viewModel.isShownSearch = true } },
            bottomBar = { NavBar(){ viewModel.selectedItem = it } },
            floatingActionButton = { ExtendedActionButton{ navController.navigate(createScreenRoute) { launchSingleTop = true }}},
            floatingActionButtonPosition = FabPosition.End,
        ){ innerPadding ->
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(innerPadding)
                    .padding(15.dp, 0.dp)
            ) {
                Text(
                    text = when (viewModel.selectedItem) {
                        1 -> stringResource(R.string.home_screem_one)
                        2 -> stringResource(R.string.home_screem_second)
                        else -> stringResource(R.string.home_screem_third)
                    },
                    fontSize = 16.sp, style = MaterialTheme.typography.labelMedium
                )
                Spacer(modifier = Modifier.height(10.dp))
                if (viewModel.listAll != null){
                    viewModel.listAll?.forEachIndexed() { _, todo ->
                        if(todo.status == viewModel.listStatus[viewModel.selectedItem-1]){
                            CardTodo(
                                todo.title,
                                todo.description,
                                todo.status,
                                todo.data,
                                todo.time,
                                { navController.navigate("$editScreenRoute/${todo.id}"){
                                    launchSingleTop = true
                                } },
                                { scope.launch{viewModel.delete(todo.id)} }
                            )
                        }
                    }
                }
            }
        }
        DialogSearch(modifier = Modifier,viewModel.isShownSearch) { viewModel.isShownSearch = it }
    }
}