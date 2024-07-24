package crud.example.com.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.crud.R

// Set of Material typography styles to start with
val Typography = Typography(
//    bodyLarge = TextStyle(
//        fontFamily = FontFamily.Default,
//        fontWeight = FontWeight.Normal,
//        fontSize = 16.sp,
//        lineHeight = 24.sp,
//        letterSpacing = 0.5.sp
//    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.inter, FontWeight.W400)),
        fontWeight = FontWeight.W400,
        letterSpacing = 0.5.sp
    ),
    labelMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.inter_medium, FontWeight.W500)),
        fontWeight = FontWeight.W500,
        letterSpacing = 0.5.sp
    ),
    bodySmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.inter_semibold, FontWeight.W600)),
        fontWeight = FontWeight.W600,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.inter_bold, FontWeight.W700)),
        fontWeight = FontWeight.W700,
        letterSpacing = 0.5.sp
    ),
   bodyLarge = TextStyle(
       fontFamily = FontFamily(Font(R.font.inter_extrabold, FontWeight.W800)),
       fontWeight = FontWeight.W700,
       letterSpacing = 0.5.sp
   ),
    titleSmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.inter, FontWeight.W400)),
        fontSize = 18.sp,
        fontWeight = FontWeight.W500,
        letterSpacing = 0.5.sp
    ),
    titleMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.inter, FontWeight.W400)),
        fontSize = 16.sp,
        fontWeight = FontWeight.W400,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.inter_medium, FontWeight.W500)),
        fontSize = 24.sp,
        fontWeight = FontWeight.W500,
        letterSpacing = 0.5.sp
    ),


    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)