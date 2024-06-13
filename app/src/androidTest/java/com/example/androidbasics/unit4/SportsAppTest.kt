package com.example.androidbasics.unit4

import androidx.activity.ComponentActivity
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.example.androidbasics.R
import com.example.androidbasics.unit4.ui.elements.SportsApp
import org.junit.Rule
import org.junit.Test

class SportsAppTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @TestCompactWidth
    @Test
    fun compactDevice_verifyDisplaysOnlyList() {
        composeTestRule.setContent {
            SportsApp(screenSize = WindowWidthSizeClass.Compact)
        }

        val tag = composeTestRule.activity.getString(R.string.sports_list)
        composeTestRule.onNodeWithTag(tag).assertExists()
    }

    @TestMediumWidth
    @Test
    fun mediumDevice_verifyDisplaysListAndDetails() {
        composeTestRule.setContent {
            SportsApp(screenSize = WindowWidthSizeClass.Medium)
        }

        val tag = composeTestRule.activity.getString(R.string.sports_list_and_details)
        composeTestRule.onNodeWithTag(tag).assertExists()
    }

    @TestExpandedWidth
    @Test
    fun expandedDevice_verifyDisplaysListAndDetails() {
        composeTestRule.setContent {
            SportsApp(screenSize = WindowWidthSizeClass.Expanded)
        }

        val tag = composeTestRule.activity.getString(R.string.sports_list_and_details)
        composeTestRule.onNodeWithTag(tag).assertExists()
    }
}