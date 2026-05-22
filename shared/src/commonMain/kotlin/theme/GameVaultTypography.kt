package theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import gamevault.core.resource.generated.resources.Res
import gamevault.core.resource.generated.resources.outfit_font
import org.jetbrains.compose.resources.Font

object GameVaultTypography {
    private val OutfitFontFamily: FontFamily
        @Composable get() = FontFamily(
            Font(Res.font.outfit_font)
        )

    val Typography: Typography
        @Composable get() = Typography(

            displayLarge = TextStyle(
                fontFamily = OutfitFontFamily,
                fontSize = 42.sp,
                letterSpacing = 0.sp,
                fontWeight = FontWeight.SemiBold
            ),
            displayMedium = TextStyle(
                fontFamily = OutfitFontFamily,
                fontSize = 35.sp,
                letterSpacing = 0.sp,
                fontWeight = FontWeight.SemiBold
            ),
            displaySmall = TextStyle(
                fontFamily = OutfitFontFamily,
                fontSize = 29.sp,
                letterSpacing = 0.sp,
                fontWeight = FontWeight.SemiBold
            ),

            titleLarge = TextStyle(
                fontFamily = OutfitFontFamily,
                fontSize = 24.sp,
                letterSpacing = 0.sp,
                fontWeight = FontWeight.SemiBold
            ),
            titleMedium = TextStyle(
                fontFamily = OutfitFontFamily,
                fontSize = 20.sp,
                letterSpacing = 0.sp,
                fontWeight = FontWeight.SemiBold
            ),
            titleSmall = TextStyle(
                fontFamily = OutfitFontFamily,
                fontSize = 17.sp,
                letterSpacing = 0.sp,
                fontWeight = FontWeight.SemiBold
            ),

            headlineLarge = TextStyle(
                fontFamily = OutfitFontFamily,
                fontSize = 14.sp,
                letterSpacing = 0.sp,
                fontWeight = FontWeight.SemiBold
            ),
            headlineMedium = TextStyle(
                fontFamily = OutfitFontFamily,
                fontSize = 12.sp,
                letterSpacing = 0.sp,
                fontWeight = FontWeight.SemiBold
            ),
            headlineSmall = TextStyle(
                fontFamily = OutfitFontFamily,
                fontSize = 10.sp,
                letterSpacing = 0.sp,
                fontWeight = FontWeight.SemiBold
            ),


            bodyLarge = TextStyle(
                fontFamily = OutfitFontFamily,
                fontSize = 14.sp,
                letterSpacing = 0.sp,
                fontWeight = FontWeight.Light
            ),
            bodyMedium = TextStyle(
                fontFamily = OutfitFontFamily,
                fontSize = 12.sp,
                letterSpacing = 0.sp,
                fontWeight = FontWeight.Light
            ),
            bodySmall = TextStyle(
                fontFamily = OutfitFontFamily,
                fontSize = 10.sp,
                letterSpacing = 0.sp,
                fontWeight = FontWeight.Light
            ),

            labelLarge = TextStyle(
                fontFamily = OutfitFontFamily,
                fontSize = 14.sp,
                letterSpacing = 0.sp,
                fontWeight = FontWeight.Light
            ),
            labelMedium = TextStyle(
                fontFamily = OutfitFontFamily,
                fontSize = 12.sp,
                letterSpacing = 0.sp,
                fontWeight = FontWeight.Light
            ),
            labelSmall = TextStyle(
                fontFamily = OutfitFontFamily,
                fontSize = 10.sp,
                letterSpacing = 0.sp,
                fontWeight = FontWeight.Light
            )
        )
}