package dev.pastukhov.waharoster.ui.bills

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import dev.pastukhov.waharoster.data.Bill
import dev.pastukhov.waharoster.data.UserData
import dev.pastukhov.waharoster.ui.components.BillRow
import dev.pastukhov.waharoster.ui.components.StatementBody

/**
 * The Bills screen.
 */
@Composable
fun BillsScreen(
    bills: List<Bill> = remember { UserData.bills }
) {
    StatementBody(
        modifier = Modifier.clearAndSetSemantics { contentDescription = "Bills" },
        items = bills,
        amounts = { bill -> bill.amount },
        colors = { bill -> bill.color },
        amountsTotal = bills.map { bill -> bill.amount }.sum(),
        circleLabel = "stringResource(R.string.due)",
        rows = { bill ->
            BillRow(bill.name, bill.due, bill.amount, bill.color)
        }
    )
}
