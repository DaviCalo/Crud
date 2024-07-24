package crud.example.com.ui.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import crud.example.com.ui.theme.CRUDTheme

@Composable
fun ShowDialogComposable(isShown: Boolean, onClick: () -> Unit){
    CRUDTheme {
        if (isShown) {
            AlertDialog(
                onDismissRequest = { onClick() },
                title = { Text("Campos incompletos") },
                text = { Text("Por favor, preencha todos os campos.") },
                confirmButton = {
                    Button(onClick = { onClick() }) {
                        Text("OK")
                    }
                }
            )
        }
    }
}