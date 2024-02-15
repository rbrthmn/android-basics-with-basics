package com.example.androidbasics.unit2

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextClearance
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.androidbasics.ui.theme.AndroidBasicsTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.text.NumberFormat

@RunWith(AndroidJUnit4::class)
class TipUITest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculate_20_percent_tip() {
        composeTestRule.setContent {
            AndroidBasicsTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    TipCalculator().TipCalculatorLayout()
                }
            }
        }
        composeTestRule.onNodeWithText("Bill Amount").performTextInput("10")
        composeTestRule.onNodeWithText("Tip Percentage").performTextClearance()
        composeTestRule.onNodeWithText("Tip Percentage").performTextInput("20")
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)

        composeTestRule.onNodeWithText("Tip Amount: $expectedTip")
            .assertExists(errorMessageOnFail = NO_NODE_FOUND)
    }

    companion object {
        const val NO_NODE_FOUND = "No node with this text was found."
    }
}