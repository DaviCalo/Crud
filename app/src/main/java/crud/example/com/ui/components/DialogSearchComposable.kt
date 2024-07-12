package crud.example.com.ui.components

import android.graphics.drawable.Icon
import android.text.BoringLayout
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Icon
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import crud.example.com.ui.navigation.editScreenRoute
import crud.example.com.ui.theme.CRUDTheme
import crud.example.com.ui.viewmodels.HomeViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel
import java.util.Locale

@Composable
fun DialogSearch(
    modifier: Modifier,
    navController: NavController,
    isShown: Boolean,
    onDismissRequest: (Boolean) -> Unit
) {
    val scope = rememberCoroutineScope()
    CRUDTheme {
        val viewModel = koinViewModel<HomeViewModel>()
        if (isShown) {
            Dialog(
                properties = DialogProperties(usePlatformDefaultWidth = false),
                onDismissRequest = { onDismissRequest(false) }
            ) {
                Surface(
                    modifier = Modifier,
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .systemBarsPadding(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(color = MaterialTheme.colorScheme.surface)
                        ) {
                            OutlinedTextField(
                                leadingIcon = {
                                    IconButton(onClick = { onDismissRequest(false) }) {
                                        Icon(
                                            imageVector = Icons.Default.Close,
                                            contentDescription = "Back",
                                            tint = MaterialTheme.colorScheme.primary
                                        )
                                    }
                                },
                                textStyle = MaterialTheme.typography.labelSmall.copy(
                                    fontSize = 16.sp
                                ),
                                maxLines = 3,
                                placeholder =  { Text(text = "Procure uma tarefa", style = MaterialTheme.typography.labelMedium.copy( fontSize = 16.sp)) },
                                modifier = Modifier
                                    .border(1.dp, Color.Transparent)
                                    .padding(4.dp),
                                value = viewModel.search,
                                onValueChange = {
                                    viewModel.search = it.replaceFirstChar(Char::titlecase)
                                    viewModel.search(viewModel.search)
                                },
                                colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = Color.Transparent, unfocusedBorderColor = Color.Transparent, disabledBorderColor = Color.Transparent)
                            )
                        }
                        HorizontalDivider()
//                        Row(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(15.dp, 0.dp)
//                                .background(MaterialTheme.colorScheme.surface),
//                            horizontalArrangement = Arrangement.spacedBy(10.dp),
//                        ) {
//                            viewModel.listStatus.forEachIndexed() { _, status ->
//                                SuggestionChipExample(onClick = { /*TODO*/ }, label = status)
//                            }
//                       }
                        Spacer(modifier = Modifier.height(5.dp))
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(15.dp, 0.dp)
                                .fillMaxHeight()
                        ){
                            viewModel.filteredTodo.forEachIndexed() { _, todo ->
                                CardTodo(
                                    todo.title,
                                    todo.description,
                                    todo.status,
                                    todo.data,
                                    todo.time,
                                    {
                                        navController.navigate("$editScreenRoute/${todo.id}"){ launchSingleTop = true }
                                        onDismissRequest(false)
                                    },
                                    { scope.launch{viewModel.delete(todo.id)} }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}