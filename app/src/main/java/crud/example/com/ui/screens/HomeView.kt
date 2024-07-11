package crud.example.com.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import crud.example.com.ui.components.ExtendedActionButton
import crud.example.com.ui.components.ListAllBeggar
import crud.example.com.ui.components.NavBar
import crud.example.com.ui.components.TabBar
import crud.example.com.ui.navigation.createScreenRoute
import crud.example.com.ui.theme.CRUDTheme
import crud.example.com.ui.viewmodels.HomeViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeView(navController: NavController){
    val viewModel = koinViewModel<HomeViewModel>()
    CRUDTheme {
        Scaffold(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .systemBarsPadding(),
            topBar = { TabBar() },
            bottomBar = { NavBar(){ viewModel.selectedItem = it } },
            floatingActionButton = { ExtendedActionButton{ navController.navigate(createScreenRoute) { launchSingleTop = true }}},
            floatingActionButtonPosition = FabPosition.End,
            ) { innerPadding ->
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(innerPadding)
                    .padding(15.dp, 0.dp)
            ) {
                when(viewModel.selectedItem){
                    1 -> ListAllBeggar(navController, viewModel.selectedItem)
                    2 -> ListAllBeggar(navController, viewModel.selectedItem)
                    3 -> ListAllBeggar(navController, viewModel.selectedItem)
                }
            }
        }
    }
}