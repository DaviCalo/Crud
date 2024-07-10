package crud.example.com.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonColors
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import crud.example.com.ui.theme.CRUDTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChoiceSegmentedButton(onChoiceOneClicked: () -> Unit, onChoiceSecondClicked: () -> Unit, onChoiceThirdClicked: () -> Unit){
    var selectedItem by remember { mutableIntStateOf(0) }
    val listFun = listOf(onChoiceOneClicked, onChoiceSecondClicked, onChoiceThirdClicked)
    val options = listOf("Pendentes","Progresso","Concluídos")
    CRUDTheme {
        Row(
            modifier = Modifier.fillMaxWidth().padding(15.dp,5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            androidx.compose.material3.SingleChoiceSegmentedButtonRow {
                options.forEachIndexed { index, option ->
                    SegmentedButton(
                        colors = SegmentedButtonDefaults.colors(
                            activeContainerColor = MaterialTheme.colorScheme.secondary,
                            disabledActiveContainerColor = MaterialTheme.colorScheme.secondary,
                            activeContentColor = MaterialTheme.colorScheme.onPrimary,
                            inactiveContainerColor = MaterialTheme.colorScheme.surface
                        ),
                        selected = selectedItem == index,
                        onClick = {
                            selectedItem = index
                            listFun[index]()
                        },
                        shape = SegmentedButtonDefaults.itemShape(index = index, count = options.size),
                    ) {
                        Text(text = option, style = MaterialTheme.typography.labelLarge)
                    }
                }
            }
        }
    }
}