package crud.example.com.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.crud.R
import crud.example.com.ui.components.DynamicSelectTextFieldComposable
import crud.example.com.ui.components.InputTextFieldsComposable
import crud.example.com.ui.components.SaveButton
import crud.example.com.ui.components.ShowDialogComposable
import crud.example.com.ui.components.TabBarEdit
import crud.example.com.ui.theme.CRUDTheme
import crud.example.com.ui.viewmodels.EditViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun EditView(navController: NavController, id: String?) {
    val viewModel = koinViewModel<EditViewModel>()
    if (id != null && viewModel.init){
        viewModel.find(id)
        viewModel.init = false
    }
    CRUDTheme {
        Scaffold(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .systemBarsPadding(),
            topBar = { TabBarEdit(navController) { viewModel.clear() } }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(15.dp, 0.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column {
                    OutlinedTextField(
                        textStyle = MaterialTheme.typography.titleLarge,
                        singleLine = true,
                        maxLines = 1,
                        placeholder =  { Text("Título", style = MaterialTheme.typography.titleLarge) },
                        modifier = Modifier.border(1.dp, Color.Transparent),
                        value = viewModel.title,
                        onValueChange = { viewModel.title = it.replaceFirstChar(kotlin.Char::titlecase) },
                        colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = Color.Transparent, unfocusedBorderColor = Color.Transparent, disabledBorderColor = Color.Transparent)
                    )
                    InputTextFieldsComposable(icon = R.drawable.notes, value = viewModel.description, onValueChangedEvent = { viewModel.description = it }, placeholder = "Descrição", conDescription = "description icon", modifier = Modifier.fillMaxWidth().padding(15.dp, 0.dp))
                    InputTextFieldsComposable(icon = R.drawable.calendar_today, value = viewModel.data, onValueChangedEvent = { viewModel.data = it }, placeholder = "Data", conDescription = "calendar icon", modifier = Modifier.fillMaxWidth().padding(15.dp, 0.dp))
                    InputTextFieldsComposable(icon = R.drawable.timer, value = viewModel.timer, onValueChangedEvent = { viewModel.timer = it }, placeholder = "Hora", conDescription = "timer icon", modifier = Modifier.fillMaxWidth().padding(15.dp, 0.dp))
                    DynamicSelectTextFieldComposable(viewModel.status, viewModel.listStatus, {viewModel.status = it}, Modifier)
                }
                Row {
                    SaveButton(navController, "Editar tarefa", viewModel.isDone) { viewModel.insertTodo() }
                }
            }
            ShowDialogComposable(viewModel.showDialog){ viewModel.showDialog = false }
        }
    }
}