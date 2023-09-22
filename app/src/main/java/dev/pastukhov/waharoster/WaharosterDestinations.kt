package dev.pastukhov.waharoster

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import dev.pastukhov.waharoster.ui.accounts.AccountsScreen
import dev.pastukhov.waharoster.ui.accounts.SingleAccountScreen
import dev.pastukhov.waharoster.ui.bills.BillsScreen
import dev.pastukhov.waharoster.ui.overview.OverviewScreen

interface WaharosterDestination {
    val icon: ImageVector
    val route: String
    val screen: @Composable () -> Unit
}

object Overview : WaharosterDestination {
    override val icon = Icons.Filled.Person
    override val route = "overview"
    override val screen: @Composable () -> Unit = { OverviewScreen() }
}

object Accounts : WaharosterDestination {
    override val icon = Icons.Filled.Person
    override val route = "accounts"
    override val screen: @Composable () -> Unit = { AccountsScreen() }
}

object Bills : WaharosterDestination {
    override val icon = Icons.Filled.AccountBox
    override val route = "bills"
    override val screen: @Composable () -> Unit = { BillsScreen() }
}

object SingleAccount : WaharosterDestination {
    override val icon = Icons.Filled.Add
    override val route = "single_account"
    override val screen: @Composable () -> Unit = { SingleAccountScreen() }
    const val accountTypeArg = "account_type"
}

val tabRowScreens = listOf(Overview, Accounts, Bills)
