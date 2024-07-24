package crud.example.com.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.crud.R
import crud.example.com.ui.theme.CRUDTheme

@Composable
fun CardTodo(
    title: String,
    description: String,
    status: String,
    data: String,
    time: String,
    onEdit: () -> Unit,
    onDelete: () -> Unit
){
    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(targetValue = if (expandedState) 180f else 0f, label = "")
    CRUDTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 5.dp)
                .clip(shape = RoundedCornerShape(12.dp))
                .border(
                    0.8.dp,
                    MaterialTheme.colorScheme.primaryContainer,
                    RoundedCornerShape(12.dp)
                )
                .clickable { expandedState = !expandedState }
        ){
            Column(
                modifier = Modifier.padding(15.dp, 15.dp, 15.dp, 15.dp),
                verticalArrangement = Arrangement.spacedBy(7.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = title,
                        maxLines = 1,
                        fontSize = 20.sp,
                        modifier = Modifier.widthIn(max = 300.dp),
                        softWrap = true,
                        style = MaterialTheme.typography.bodySmall
                    )
                    Icon(painter = painterResource(id = R.drawable.arrow_drop_down),
                        contentDescription = "arrow icon",
                        Modifier.rotate(if (expandedState) 180f else 0f)
                    )
                }
                if (expandedState) {
                    Column(
                        modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(5.dp), horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = description,
                            fontSize = 16.sp,
                            style = MaterialTheme.typography.labelMedium
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(0.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "$data - $time",
                                maxLines = 1,
                                fontSize = 16.sp,
                                style = MaterialTheme.typography.labelMedium
                            )
                            Row() {
                                IconButton(
                                    modifier = Modifier.padding(0.dp),
                                    onClick = {
                                        onEdit()
                                        expandedState = !expandedState
                                    }
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Edit,
                                        contentDescription = null,
                                    )
                                }
                                IconButton(
                                    modifier = Modifier.padding(0.dp),
                                    onClick = {
                                        onDelete()
                                        expandedState = !expandedState
                                    }
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Delete,
                                        contentDescription = null,
                                    )
                                }
                            }

                        }
                    }
                }
            }
        }
    }
}