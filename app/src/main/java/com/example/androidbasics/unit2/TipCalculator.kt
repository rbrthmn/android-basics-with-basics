package com.example.androidbasics.unit2

import androidx.annotation.StringRes
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidbasics.R
import java.text.NumberFormat

class TipCalculator {

    @Preview
    @Composable
    fun TipCalculatorLayout(modifier: Modifier = Modifier) {
        var inputAmount by remember { mutableStateOf("") }
        var inputPercentage by remember { mutableStateOf("15") }
        var roundUp by remember { mutableStateOf(false) }

        val amount = inputAmount.toDoubleOrNull() ?: 0.0
        val percentage = inputPercentage.toDoubleOrNull() ?: 0.0
        val tip = calculateTip(amount = amount, tipPercent = percentage, roundUp = roundUp)

        Surface(modifier = modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .statusBarsPadding()
                    .padding(horizontal = 40.dp)
                    .verticalScroll(rememberScrollState())
                    .safeDrawingPadding(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(R.string.calculate_tip),
                    modifier = Modifier
                        .padding(bottom = 16.dp, top = 40.dp)
                        .align(alignment = Alignment.Start)
                )
                EditNumberField(
                    label = R.string.bill_amount,
                    value = inputAmount,
                    onValueChange = { inputAmount = it },
                    imeAction = ImeAction.Next,
                    modifier = Modifier
                        .padding(bottom = 32.dp)
                        .fillMaxWidth()
                )
                EditNumberField(
                    label = R.string.how_was_the_service,
                    value = inputPercentage,
                    onValueChange = { inputPercentage = it },
                    imeAction = ImeAction.Done,
                    modifier = Modifier
                        .padding(bottom = 32.dp)
                        .fillMaxWidth()
                )
                RoundTheTipRow(
                    modifier = Modifier.padding(bottom = 32.dp),
                    onCheckedChange = { roundUp = it },
                    roundUp = roundUp
                )
                Text(
                    text = stringResource(R.string.tip_amount, tip),
                    style = MaterialTheme.typography.displaySmall
                )
                Spacer(modifier = Modifier.height(150.dp))
            }
        }
    }

    @Composable
    fun EditNumberField(
        @StringRes label: Int,
        value: String,
        onValueChange: (String) -> Unit,
        imeAction: ImeAction,
        modifier: Modifier = Modifier
    ) {
        TextField(
            value = value,
            onValueChange = { onValueChange(it) },
            label = { Text(stringResource(id = label)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = imeAction
            ),
            modifier = modifier
        )
    }

    @VisibleForTesting
    internal fun calculateTip(amount: Double, tipPercent: Double = 15.0, roundUp: Boolean): String {
        var tip = tipPercent / 100 * amount
        if (roundUp) {
            tip = kotlin.math.ceil(tip)
        }
        return NumberFormat.getCurrencyInstance().format(tip)
    }

    @Composable
    fun RoundTheTipRow(
        roundUp: Boolean,
        onCheckedChange: (Boolean) -> Unit,
        modifier: Modifier = Modifier
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .size(48.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(stringResource(id = R.string.round_up_tip))
            Switch(
                checked = roundUp,
                onCheckedChange = { onCheckedChange(it) },
                modifier = modifier
            )
        }
    }
}