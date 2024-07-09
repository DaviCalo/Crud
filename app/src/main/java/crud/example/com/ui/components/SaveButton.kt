package crud.example.com.ui.components

import android.inputmethodservice.Keyboard
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.crud.R
import crud.example.com.ui.navigation.homeScreenRoute
import java.lang.reflect.Modifier

@Composable
fun SaveButton(navController: NavController, action: String, isDone: Boolean, onClick: () -> Unit,){
    Row(
        modifier = androidx.compose.ui.Modifier
            .fillMaxWidth()
            .padding(15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Button(
            modifier =  androidx.compose.ui.Modifier
                .fillMaxWidth().height(45.dp),
            shape = RoundedCornerShape(10.dp),
            onClick = {
                onClick()
                if(isDone) {
                    println(isDone)
                    navController.navigate(homeScreenRoute)
                }
            }
        ) {
            Text(text = action, style = MaterialTheme.typography.bodyMedium, fontSize = 14.sp)
        }
    }
}