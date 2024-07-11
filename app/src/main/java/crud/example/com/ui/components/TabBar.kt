package crud.example.com.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.crud.R

@Composable
fun TabBar(
    onClick: () -> Unit
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp, 5.dp),
            contentAlignment = Alignment.Center
        ){
            Text(text = "ToDo", fontSize = 20.sp, style = MaterialTheme.typography.bodySmall, modifier = Modifier.align(Alignment.CenterStart))
            IconButton(onClick = { onClick() }, modifier = Modifier.align(Alignment.CenterEnd)) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_search),
                    contentDescription = "Lupa",
                    tint = MaterialTheme.colorScheme.primary,
                )
            }
        }
    }
}


//@Composable
//fun TabBar(navController: NavController?, screen: Int){
//    var selectedItem by remember { mutableIntStateOf(screen) }
//    val items = listOf("Home", "Criar","Alterar", "Deletar")
//    val itemsIcon = listOf(R.drawable.icon_home, R.drawable.icon_pen, R.drawable.iconicon_email, R.drawable.icon_person)
//    val navigates = listOf(homeScreenRoute, createScreenRoute, editScreenRoute, deleteScreenRoute)
//    CRUDTheme {
//        NavigationBar(
//            containerColor = Color.Transparent,
//        ){
//            items.forEachIndexed { index, item ->
//                NavigationBarItem(
//                    icon = { Icon(painter = painterResource(itemsIcon[index]), contentDescription = item) },
//                    label = {
//                        if (selectedItem == index){
//                            Text(item, style = MaterialTheme.typography.bodyMedium)
//                        }else  Text(item, style = MaterialTheme.typography.labelLarge)
//                    },
//                    colors = NavigationBarItemDefaults.colors(
//                        selectedIconColor = MaterialTheme.colorScheme.primary,
//                        selectedTextColor=  MaterialTheme.colorScheme.onPrimary,
//                        indicatorColor = MaterialTheme.colorScheme.secondary,
//                        unselectedIconColor = MaterialTheme.colorScheme.onSecondary,
//                        unselectedTextColor = MaterialTheme.colorScheme.onSecondary,
//                    ),
//                    selected = selectedItem == index,
//                    onClick = {
//                        if (selectedItem != index){
//                            navController?.navigate(navigates[index]){
//                                launchSingleTop = true
//                            }
//                        }
//                        selectedItem = index
//                    }
//                )
//            }
//        }
//    }
//}

//
//@Preview(
//    showBackground = true,
//    backgroundColor = 5,
//    uiMode = Configuration.UI_MODE_NIGHT_YES,
//    name = "Default Preview Dark"
//)
//@Composable
//fun PreviewTabBar(){
//    val navController = rememberNavController()
//    TabBar(navController, 0)
//}