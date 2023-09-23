package dev.pastukhov.waharoster.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.pastukhov.waharoster.Accounts
import dev.pastukhov.waharoster.Bills
import dev.pastukhov.waharoster.Overview
import dev.pastukhov.waharoster.WaharosterDestination
import dev.pastukhov.waharoster.ui.theme.WaharosterTheme

@Composable
fun BottomNavigation(
    allScreens: List<WaharosterDestination>, onTabSelected: (WaharosterDestination) -> Unit, currentScreen: WaharosterDestination
) {

    Row(
        Modifier
            .height(IntrinsicSize.Min)
            .fillMaxWidth()
            .selectableGroup()
    ) {
        allScreens.forEach { screen ->
            BottomNavigationItem(
                modifier = Modifier.weight(1F),
                text = screen.route,
                icon = screen.icon,
                onSelected = { onTabSelected(screen) },
                selected = currentScreen == screen
            )
        }
    }
}

@Composable
private fun BottomNavigationItem(
    modifier: Modifier = Modifier, text: String, icon: ImageVector, onSelected: () -> Unit, selected: Boolean
) {
    val color = MaterialTheme.colorScheme.onSurface
    val durationMillis = if (selected) TabFadeInAnimationDuration else TabFadeOutAnimationDuration
    val animSpec = remember {
        tween<Color>(
            durationMillis = durationMillis, easing = LinearEasing, delayMillis = TabFadeInAnimationDelay
        )
    }
    val tabTintColor by animateColorAsState(
        targetValue = if (selected) color else color.copy(alpha = InactiveTabOpacity), animationSpec = animSpec, label = ""
    )

    Column(modifier = modifier
        .padding(16.dp)
        .animateContentSize()
        // .height(TabHeight)
        .selectable(
            selected = selected,
            onClick = onSelected,
            role = Role.Tab,
            interactionSource = remember { MutableInteractionSource() },
            indication = rememberRipple(
                bounded = false, radius = Dp.Unspecified, color = Color.Unspecified
            )
        )
        .clearAndSetSemantics { contentDescription = text }
        .fillMaxHeight(), horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(imageVector = icon, contentDescription = text, tint = tabTintColor)
        Spacer(Modifier.width(12.dp))
        Text(text, color = tabTintColor)
    }
}

private const val InactiveTabOpacity = 0.60f

private const val TabFadeInAnimationDuration = 150
private const val TabFadeInAnimationDelay = 100
private const val TabFadeOutAnimationDuration = 100

@Preview
@Composable
fun BottomNavigationPreview() {
    WaharosterTheme {
        BottomNavigation(
            allScreens = listOf(Overview, Accounts, Bills),
            onTabSelected = {},
            currentScreen = Overview,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationItemPreview() {
    WaharosterTheme {
        Column {
            BottomNavigationItem(
                text = "Overview2",
                icon = Icons.Filled.Person,
                onSelected = {},
                selected = false,
            )

            BottomNavigationItem(
                text = "Overview",
                icon = Icons.Filled.AccountBox,
                onSelected = {},
                selected = true,
            )

            BottomNavigationItem(
                text = "Overview2",
                icon = Icons.Filled.Phone,
                onSelected = {},
                selected = false,
            )
        }
    }
}
