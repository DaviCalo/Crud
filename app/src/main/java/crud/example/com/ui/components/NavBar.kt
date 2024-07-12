package crud.example.com.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.crud.R

@Composable
fun NavBar(
    onChange: (Int) -> Unit
){
    var selectedItem by remember { mutableIntStateOf(1) }
    val widthBackground = 75.dp
    val heightBackground = 60.dp
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp,0.dp,0.dp,8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Row(
            Modifier
                .clip(RoundedCornerShape(35.dp))
                .background(MaterialTheme.colorScheme.surface)
                .padding(2.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconSelect(widthBackground, heightBackground, selectedItem, 1, onChange = { selectedItem = it }, R.drawable.clock_loader_2, R.drawable.clock_loader_select_2,  { onChange(selectedItem)} )
            IconSelect(widthBackground, heightBackground, selectedItem, 2, onChange = { selectedItem = it }, R.drawable.sync_2, R.drawable.sync_select_2, { onChange(selectedItem)})
            IconSelect(widthBackground, heightBackground, selectedItem, 3, onChange = { selectedItem = it }, R.drawable.check_circle, R.drawable.check_circle_select, { onChange(selectedItem)})
        }
    }
}

@Composable
fun IconSelect(
    widthBackground: Dp,
   heightBackground: Dp,
   selectedItem: Int,
   item: Int,
   onChange: (Int) -> Unit,
   @DrawableRes icon: Int,
   @DrawableRes iconSelected: Int,
   onClink: () -> Unit
){
    var color: Color? = null
    color = if (selectedItem == item) MaterialTheme.colorScheme.primary else Color.Transparent
    Box(
        modifier = Modifier
            .width(widthBackground)
            .height(heightBackground)
            .clip(RoundedCornerShape(50))
            .background(color),
        contentAlignment = Alignment.Center
    ) {
        IconButton(onClick = {
            onChange(item)
            onClink()
        }) {
            Icon(
                painter = if(selectedItem == item) painterResource(id = iconSelected) else painterResource(icon),
                contentDescription = "icon",
                modifier = Modifier.size(30.dp),
                tint = if(selectedItem == item) Color.White else Color.Gray
            )
        }
    }
}
