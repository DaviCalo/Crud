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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.crud.R
import crud.example.com.ui.components.SaveButton
import crud.example.com.ui.components.TabBar
import crud.example.com.ui.components.TabBarEdit
import crud.example.com.ui.theme.CRUDTheme
import crud.example.com.ui.viewmodels.CreateViewModel
import crud.example.com.ui.viewmodels.HomeViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun CreateView(navController: NavController) {
    val viewModel = koinViewModel<CreateViewModel>()
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
                    .padding(6.dp, 0.dp),
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
                        onValueChange = { viewModel.title = it },
                        colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = Color.Transparent, unfocusedBorderColor = Color.Transparent, disabledBorderColor = Color.Transparent)
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp, 0.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Icon(painter = painterResource(id = R.drawable.notes), contentDescription = "notes icon")
                        OutlinedTextField(
                            textStyle = MaterialTheme.typography.titleMedium,
                            maxLines = 3,
                            placeholder =  { Text("Descrição", style = MaterialTheme.typography.titleSmall, fontSize = 18.sp) },
                            modifier = Modifier.border(1.dp, Color.Transparent),
                            value = viewModel.description,
                            onValueChange = { viewModel.description = it },
                            colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = Color.Transparent, unfocusedBorderColor = Color.Transparent, disabledBorderColor = Color.Transparent)
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp, 0.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Icon(painter = painterResource(id = R.drawable.calendar_today), contentDescription = "calendar icon")
                        OutlinedTextField(
                            textStyle = MaterialTheme.typography.titleMedium,
                            singleLine = true,
                            maxLines = 3,
                            placeholder =  { Text("Data", style = MaterialTheme.typography.titleSmall, fontSize = 18.sp) },
                            modifier = Modifier.border(1.dp, Color.Transparent),
                            value = viewModel.data,
                            onValueChange = { viewModel.data = it },
                            colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = Color.Transparent, unfocusedBorderColor = Color.Transparent, disabledBorderColor = Color.Transparent)
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp, 0.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Icon(painter = painterResource(id = R.drawable.timer), contentDescription = "timer icon")
                        OutlinedTextField(
                            textStyle = MaterialTheme.typography.titleMedium,
                            singleLine = true,
                            maxLines = 3,
                            placeholder =  { Text("Hora", style = MaterialTheme.typography.titleSmall, fontSize = 18.sp) },
                            modifier = Modifier.border(1.dp, Color.Transparent),
                            value = viewModel.timer,
                            onValueChange = { viewModel.timer = it },
                            colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = Color.Transparent, unfocusedBorderColor = Color.Transparent, disabledBorderColor = Color.Transparent)
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp, 0.dp, 0.dp, 0.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Icon(painter = painterResource(id = R.drawable.filter_list), contentDescription = "timer icon")
                        DynamicSelectTextField(viewModel.status, viewModel.listStatus, {viewModel.status = it}, Modifier)
                    }
                }
                Row {
                    SaveButton(navController, "Criar tarefa", viewModel.isDone) { viewModel.insertTodo()}
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DynamicSelectTextField(
    selectedValue: String,
    options: List<String>,
    onValueChangedEvent: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    CRUDTheme {
        var expanded by remember { mutableStateOf(false) }
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded },
            modifier = modifier
        ) {
            OutlinedTextField(
                readOnly = true,
                value = selectedValue,
                onValueChange = {},
                textStyle = MaterialTheme.typography.titleMedium,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                },
                placeholder =  { Text("Status", style = MaterialTheme.typography.titleSmall) },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Transparent, unfocusedBorderColor = Color.Transparent, disabledBorderColor = Color.Transparent
                ),
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
            )
            ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                options.forEach { option: String ->
                    DropdownMenuItem(
                        text = { Text(text = option,  style = MaterialTheme.typography.titleMedium) },
                        onClick = {
                            expanded = false
                            onValueChangedEvent(option)
                        }
                    )
                }
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
//fun PreviewCreate(){
//    val navController = rememberNavController()
//    CreateView(navController)
//}