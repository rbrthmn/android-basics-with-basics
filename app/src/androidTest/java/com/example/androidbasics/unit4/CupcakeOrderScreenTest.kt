package com.example.androidbasics.unit4

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.androidbasics.R
import com.example.androidbasics.unit4.data.DataSource
import com.example.cupcake.ui.SelectOptionScreen
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CupcakeOrderScreenTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()


    @Before
    fun setup_selectOptionScreen() {
        composeTestRule.setContent {
            SelectOptionScreen(subtotal = SUBTOTAL, options = flavors)
        }
    }

    @Test
    fun selectOptionScreen_verifyContent() {
        flavors.forEach { flavor ->
            composeTestRule.onNodeWithText(flavor).assertIsDisplayed()
        }

        composeTestRule.onNodeWithText(
            composeTestRule.activity.getString(
                R.string.subtotal_price,
                SUBTOTAL
            )
        ).assertIsDisplayed()

        composeTestRule.onNodeWithStringId(R.string.next).assertIsNotEnabled()
    }

    @Test
    fun selectOptionScreen_nextButtonEnabled() {
        composeTestRule.onNodeWithStringId(DataSource.flavors.first()).performClick()
        composeTestRule.onNodeWithStringId(R.string.next).assertIsEnabled()
    }

    private companion object {
        val flavors = listOf("Vanilla", "Chocolate", "Hazelnut", "Cookie", "Mango")
        const val SUBTOTAL = "$100"
    }
}