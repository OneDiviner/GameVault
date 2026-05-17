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
            headlineLarge = TextStyle(
                fontFamily = OutfitFontFamily,
                fontSize = 20.sp,
                letterSpacing = 0.sp,
                fontWeight = FontWeight.Bold
            )
        )
}