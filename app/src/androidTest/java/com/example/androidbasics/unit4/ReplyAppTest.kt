package com.example.androidbasics.unit4

import androidx.activity.ComponentActivity
import androidx.collection.mutableIntListOf
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.example.androidbasics.R
import com.example.androidbasics.unit4.ui.elements.ReplyApp
import org.junit.Rule
import org.junit.Test

class ReplyAppTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @TestCompactWidth
    @Test
    fun compactDevice_verifyUsingBottomNavigation() {
        composeTestRule.setContent {
            ReplyApp(windowSize = WindowWidthSizeClass.Compact)
        }

        val tag = composeTestRule.activity.getString(R.string.navigation_bottom)
        composeTestRule.onNodeWithTag(tag).assertExists()
    }

    @TestMediumWidth
    @Test
    fun mediumDevice_verifyUsingRailNavigation() {
        composeTestRule.setContent {
            ReplyApp(windowSize = WindowWidthSizeClass.Medium)
        }

        val tag = composeTestRule.activity.getString(R.string.navigation_rail)
        composeTestRule.onNodeWithTag(tag).assertExists()
    }

    @TestExpandedWidth
    @Test
    fun expandedDevice_verifyUsingPermanentDrawerNavigation() {
        composeTestRule.setContent {
            ReplyApp(windowSize = WindowWidthSizeClass.Expanded)
        }

        val tag = composeTestRule.activity.getString(R.string.navigation_drawer)
        composeTestRule.onNodeWithTag(tag).assertExists()
    }
}