package crud.example.com.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.crud.R
import crud.example.com.ui.navigation.createScreenRoute
import crud.example.com.ui.navigation.editScreenRoute
import crud.example.com.ui.navigation.homeScreenRoute
import crud.example.com.ui.theme.CRUDTheme

@Composable
fun TabBar(){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp, 5.dp),
            contentAlignment = Alignment.Center
        ){
            Text(text = "Sua lista", fontSize = 20.sp, style = MaterialTheme.typography.bodyLarge, modifier = Modifier.align(Alignment.Center))
            IconButton(onClick = { /*TODO*/ }, modifier = Modifier.align(Alignment.CenterEnd)) {
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