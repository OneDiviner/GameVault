package com.example.impl.presentation.components.topbar

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.Colors
import com.example.designsystem.Icons
import com.example.designsystem.Shapes
import com.example.designsystem.Spacings
import com.example.designsystem.Typography
import com.example.impl.presentation.components.SearchTextField
import org.jetbrains.compose.resources.painterResource

@Composable
internal fun HomeTopBar(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(Spacings.small)
    ) {
        Text(
            modifier = Modifier,
            text = "Popular Games",
            color = Colors.onBackground,
            style = Typography.titleMedium
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(Spacings.small)
        ) {
            SearchTextField(
                modifier = Modifier
                    .border(
                        width = 1.dp,
                        color = Colors.border,
                        shape = RoundedCornerShape(Shapes.extraLarge)
                    )
                    .weight(1f),
                placeholder = "Search...",
                onSearchButtonCLick = {

                }
            )
            Box(
                modifier = Modifier
                    .background(
                        color = Colors.surface,
                        shape = CircleShape
                    )
                    .border(
                        width = 1.dp,
                        color = Colors.border,
                        shape = CircleShape
                    )
                    .clip(CircleShape)
                    .clickable(
                        enabled = true,
                        onClick = {}
                    )
                    .padding(Spacings.small),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(Icons.gamepad),
                    contentDescription = null,
                    tint = Colors.onSurface
                )
            }
        }
    }
}

@Composable
@Preview
private fun HomeTopBarPreview() {
    HomeTopBar()
}