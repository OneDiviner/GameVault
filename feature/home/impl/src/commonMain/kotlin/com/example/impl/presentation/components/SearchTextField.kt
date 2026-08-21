package com.example.impl.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
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
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.Colors
import com.example.designsystem.Icons
import com.example.designsystem.Spacings
import com.example.designsystem.Typography
import com.example.designsystem.Shapes
import gamevault.core.designsystem.generated.resources.Res
import gamevault.core.designsystem.generated.resources.search_icon
import org.jetbrains.compose.resources.painterResource

@Composable
internal fun SearchTextField(
    modifier: Modifier = Modifier,
    color: Color = Colors.surface,
    textColor: Color = Colors.onSurface,
    placeholder: String? = null,
    leadIcon: Painter = painterResource(Res.drawable.search_icon),
    iconTint: Color = Colors.onSurface,
    shape: Shape = RoundedCornerShape(Spacings.extraLarge),
    onSearchButtonCLick: (String) -> Unit
) {

    val focusManager = LocalFocusManager.current

    var isFocused by remember { mutableStateOf(false) }
    var searchQueryValue by remember { mutableStateOf("") }

    BasicTextField(
        modifier = modifier
            .clip(shape)
            .onFocusChanged {
                isFocused = it.isFocused
                if (!it.isFocused) {
                    focusManager.clearFocus()
                }
            },
        value = searchQueryValue,
        onValueChange = { searchQueryValue = it },
        enabled = true,
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                focusManager.clearFocus()
                onSearchButtonCLick(searchQueryValue)
            }
        ),
        cursorBrush = SolidColor(Colors.onSurface),
        textStyle = Typography.labelLarge.copy(color = Colors.onBackground),
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier
                    .background(color = color)
                    .padding(
                        horizontal = Spacings.medium,
                        vertical = Spacings.small
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(Spacings.small)
            ) {
                Icon(
                    painter = leadIcon,
                    contentDescription = "search_icon",
                    modifier = Modifier.size(24.dp),
                    tint = iconTint
                )
                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.CenterStart
                ) {
                    innerTextField()
                    if (searchQueryValue.isEmpty()) {
                        Text(
                            modifier = Modifier,
                            text = placeholder ?: "", //TODO: To text resources
                            color = Colors.onSurface.copy(0.85f), //TODO: Check it
                            style = Typography.labelLarge
                        )
                    }
                }
            }
        }
    )
}

@Composable
@Preview
private fun SearchTextFieldPreview() {
    SearchTextField(
        color = Colors.surface,
        placeholder = "Search...",
        onSearchButtonCLick = {}
    )
}