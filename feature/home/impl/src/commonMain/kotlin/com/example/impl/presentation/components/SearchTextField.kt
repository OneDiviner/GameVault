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
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.impl.presentation.contract.HomeIntent
import gamevault.core.resource.generated.resources.Res
import gamevault.core.resource.generated.resources.gamepad_icon
import gamevault.core.resource.generated.resources.search_icon
import org.jetbrains.compose.resources.painterResource

@Composable
internal fun SearchTextField(
    modifier: Modifier = Modifier,
    onSearchButtonCLick: (String) -> Unit
) {

    var isFocused by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current
    var searchQueryValue by remember { mutableStateOf("") }

    BasicTextField(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp))
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
        cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
        textStyle = MaterialTheme.typography.labelLarge.copy(color = MaterialTheme.colorScheme.onBackground), //FIXME: This should not be this
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier
                    .background(
                        color = MaterialTheme.colorScheme.onBackground.copy(0.15f),
                        shape = RoundedCornerShape(24.dp)
                    )
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(
                    painter = painterResource(Res.drawable.search_icon),
                    contentDescription = "search_icon",
                    modifier = Modifier.size(24.dp),
                    tint = MaterialTheme.colorScheme.onBackground.copy(0.85f)
                )
                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.CenterStart
                ) {
                    innerTextField()
                    if (searchQueryValue.isEmpty()) {
                        Text(
                            modifier = Modifier,
                            text = "Search...", //TODO: To text resources
                            color = MaterialTheme.colorScheme.onBackground.copy(0.85f), //TODO: Check it
                            style = MaterialTheme.typography.labelLarge
                        )
                    }
                }
            }
        }
    )
}