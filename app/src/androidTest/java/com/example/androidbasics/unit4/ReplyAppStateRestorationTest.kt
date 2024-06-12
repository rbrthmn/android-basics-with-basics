package com.example.androidbasics.unit4

import androidx.activity.ComponentActivity
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.ui.test.assertAny
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasAnyDescendant
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.StateRestorationTester
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.androidbasics.R
import com.example.androidbasics.unit4.data.local.LocalEmailsDataProvider
import com.example.androidbasics.unit4.ui.elements.ReplyApp
import org.junit.Rule
import org.junit.Test

class ReplyAppStateRestorationTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @TestCompactWidth
    @Test
    fun compactDevice_selectedEmailEmailRetained_afterConfigChange() {
        val stateRestorationTest = StateRestorationTester(composeTestRule).apply {
            setContent {
                ReplyApp(windowSize = WindowWidthSizeClass.Compact)
            }
        }

        composeTestRule.run {
            onNodeWithText(
                composeTestRule.activity.getString(LocalEmailsDataProvider.allEmails[2].body)
            ).assertIsDisplayed()

            onNodeWithText(
                composeTestRule.activity.getString(LocalEmailsDataProvider.allEmails[2].subject)
            ).performClick()

            onNodeWithContentDescription(
                composeTestRule.activity.getString(R.string.navigation_back)
            ).assertExists()
            onNodeWithText(
                composeTestRule.activity.getString(LocalEmailsDataProvider.allEmails[2].body)
            ).assertExists()
        }

        stateRestorationTest.emulateSavedInstanceStateRestore()

        composeTestRule.run {
            onNodeWithContentDescription(
                composeTestRule.activity.getString(R.string.navigation_back)
            ).assertExists()
            onNodeWithText(
                composeTestRule.activity.getString(LocalEmailsDataProvider.allEmails[2].body)
            ).assertExists()
        }
    }

    @TestExpandedWidth
    @Test
    fun expandedDevice_selectedEmailEmailRetained_afterConfigChange() {
        val stateRestorationTest = StateRestorationTester(composeTestRule).apply {
            setContent { ReplyApp(windowSize = WindowWidthSizeClass.Expanded) }
        }

        composeTestRule.run {
            onNodeWithText(
                composeTestRule.activity.getString(LocalEmailsDataProvider.allEmails[2].body)
            ).assertIsDisplayed()

            onNodeWithText(
                composeTestRule.activity.getString(LocalEmailsDataProvider.allEmails[2].subject)
            ).performClick()

            onNodeWithTag(composeTestRule.activity.getString(R.string.details_screen)).onChildren()
                .assertAny(
                    hasAnyDescendant(
                        hasText(
                            composeTestRule.activity.getString(LocalEmailsDataProvider.allEmails[2].body)
                        )
                    )
                )
        }

        stateRestorationTest.emulateSavedInstanceStateRestore()

        composeTestRule.onNodeWithTag(composeTestRule.activity.getString(R.string.details_screen))
            .onChildren()
            .assertAny(
                hasAnyDescendant(
                    hasText(
                        composeTestRule.activity.getString(LocalEmailsDataProvider.allEmails[2].body)
                    )
                )
            )
    }
}