package crud.example.com.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun ExtendedActionButton(onClick: () -> Unit){
    FloatingActionButton(
        onClick = { onClick() },
        containerColor = MaterialTheme.colorScheme.primary
    ) {
        Icon(Icons.Filled.Add, "Floating action button.", tint = MaterialTheme.colorScheme.surface)
    }
}
