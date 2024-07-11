package crud.example.com.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import crud.example.com.ui.navigation.homeScreenRoute
import crud.example.com.ui.theme.CRUDTheme

@Composable
fun SaveButton(navController: NavController, action: String, isDone: Boolean, onClick: () -> Unit,){
    CRUDTheme {
        if(isDone) {navController.navigate(homeScreenRoute){launchSingleTop = true}}
        Row(
            modifier = androidx.compose.ui.Modifier
                .fillMaxWidth()
                .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Button(
                modifier = androidx.compose.ui.Modifier
                    .fillMaxWidth()
                    .height(45.dp),
                shape = RoundedCornerShape(10.dp),
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    MaterialTheme.colorScheme.primary
                ),
                onClick = { onClick() }
            ) {
                Text(text = action, style = MaterialTheme.typography.bodyMedium, fontSize = 14.sp)
            }
        }
    }
}