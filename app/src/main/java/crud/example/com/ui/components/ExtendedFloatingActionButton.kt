package crud.example.com.ui.components

import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember

@Composable
fun ExtendedActionButton(onClick: () -> Unit){
//    val listState = rememberLazyListState()
//    val expandedFab by remember { derivedStateOf { listState.firstVisibleItemIndex == 0 } }
//    androidx.compose.material3.ExtendedFloatingActionButton(
//        containerColor = MaterialTheme.colorScheme.secondary,
//        onClick = { onClick() },
//        expanded = expandedFab,
//        icon = { Icon(Icons.Filled.Add, "Localized Description") },
//        text = { Text("Adicionar", style = MaterialTheme.typography.bodyMedium) },
//    )
    FloatingActionButton(
        onClick = { onClick() },
        containerColor = MaterialTheme.colorScheme.secondary
    ) {
        Icon(Icons.Filled.Add, "Floating action button.")
    }
}
