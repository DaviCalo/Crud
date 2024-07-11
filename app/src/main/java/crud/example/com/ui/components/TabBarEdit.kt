package crud.example.com.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun TabBarEdit(navController: NavController, onClear: () -> Unit){
    Row(
        modifier = Modifier.padding(12.dp, 5.dp).fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TextButton(onClick = { navController.popBackStack() }) {
            Text(text = "Voltar", fontSize = 15.sp, style = MaterialTheme.typography.bodySmall)
        }
        Text(text = "Edite sua tarefa", fontSize = 20.sp, style = MaterialTheme.typography.bodySmall)
        TextButton(onClick = { onClear() }) {
            Text(text = "Limpar", fontSize = 15.sp, style = MaterialTheme.typography.bodySmall)
        }
    }
}