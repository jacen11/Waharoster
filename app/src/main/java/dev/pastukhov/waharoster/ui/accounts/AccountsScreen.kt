package dev.pastukhov.waharoster.ui.accounts

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import dev.pastukhov.waharoster.data.UserData
import dev.pastukhov.waharoster.ui.components.AccountRow
import dev.pastukhov.waharoster.ui.components.StatementBody

/**
 * The Accounts screen.
 */
@Composable
fun AccountsScreen(
    onAccountClick: (String) -> Unit = {},
) {
    Column {
        Button(onClick = { /*TODO*/ }, modifier = Modifier) {
            Text(text = "sdfifsdf")
        }
        Button(onClick = { /*TODO*/ }, modifier = Modifier) {
            Text(text = "hfghfgdh")
        }
    }

}

/**
 * Detail screen for a single account.
 */
@Composable
fun SingleAccountScreen(
    accountType: String? = UserData.accounts.first().name
) {
    val account = remember(accountType) { UserData.getAccount(accountType) }
    StatementBody(
        items = listOf(account),
        colors = { account.color },
        amounts = { account.balance },
        amountsTotal = account.balance,
        circleLabel = account.name,
    ) { row ->
        AccountRow(
            name = row.name,
            number = row.number,
            amount = row.balance,
            color = row.color
        )
    }
}
