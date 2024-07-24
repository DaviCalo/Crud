package crud.example.com.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import crud.example.com.ui.theme.CRUDTheme

@Composable
fun InputTextFieldsComposable(
    @DrawableRes icon:Int,
    value: String,
    onValueChangedEvent: (String) -> Unit,
    placeholder: String,
    conDescription: String,
    modifier: Modifier = Modifier
){
    CRUDTheme {
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(painter = painterResource(id = icon), contentDescription = conDescription)
            OutlinedTextField(
                textStyle = MaterialTheme.typography.titleMedium,
                maxLines = 3,
                placeholder =  { Text(placeholder, style = MaterialTheme.typography.titleSmall, fontSize = 18.sp) },
                modifier = Modifier.border(1.dp, Color.Transparent),
                value = value,
                onValueChange = { onValueChangedEvent(it.replaceFirstChar(Char::titlecase)) },
                colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = Color.Transparent, unfocusedBorderColor = Color.Transparent, disabledBorderColor = Color.Transparent)
            )
        }
    }
}