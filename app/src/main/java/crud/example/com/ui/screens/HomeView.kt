package crud.example.com.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.crud.R
import crud.example.com.ui.components.CardTodo
import crud.example.com.ui.components.ChoiceSegmentedButton
import crud.example.com.ui.components.ExtendedActionButton
import crud.example.com.ui.components.ListAllBeggar
import crud.example.com.ui.components.TabBar
import crud.example.com.ui.navigation.createScreenRoute
import crud.example.com.ui.theme.CRUDTheme
import crud.example.com.ui.viewmodels.HomeViewModel
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavController){
    val viewModel = koinViewModel<HomeViewModel>()
    CRUDTheme {
        Scaffold(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .systemBarsPadding(),
            topBar = { TabBar() },
            bottomBar = { ChoiceSegmentedButton(onChoiceOneClicked = { viewModel.selectedItem = 1 }, onChoiceSecondClicked = { viewModel.selectedItem = 2 }, onChoiceThirdClicked = { viewModel.selectedItem = 3})},
            floatingActionButton = { ExtendedActionButton{ navController.navigate(createScreenRoute) { launchSingleTop = true }}},
            floatingActionButtonPosition = FabPosition.End,
            ) { innerPadding ->
            Column(
                modifier = Modifier
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






//Button(onClick = {
////                    scope.launch {
////                        try{
////                          viewModel.allTodos
////                        }catch (e: Exception){
////                            println(e.message)
////                        }
////                    }
////                }) { Text(text = "Insert") }


//@Preview(
//    showBackground = true,
//    uiMode = Configuration.UI_MODE_NIGHT_NO,
//    name = "Default Preview Dark"
//)
//@Composable
//fun PreviewHome(){
//    val navController = rememberNavController()
//    HomeView(navController)
//}