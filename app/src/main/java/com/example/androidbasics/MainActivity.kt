package com.example.androidbasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidbasics.unit4.ui.elements.SportsApp
import com.example.androidbasics.unit4.ui.theme.SportsTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            val screenSize = calculateWindowSizeClass(activity = this)
            SportsTheme {
                Surface {
                    SportsApp(screenSize = screenSize.widthSizeClass)
                }
            }
        }
    }

    @Preview
    @Composable
    fun SportsAppCompactPreview() {
        SportsTheme {
            Surface {
                SportsApp(screenSize = WindowWidthSizeClass.Compact)
            }
        }
    }

    @Preview(widthDp = 700)
    @Composable
    fun SportsAppMediumPreview() {
        SportsTheme {
            Surface {
                SportsApp(screenSize = WindowWidthSizeClass.Medium)
            }
        }
    }

    @Preview(widthDp = 1000)
    @Composable
    fun SportsAppExpandedPreview() {
        SportsTheme {
            Surface {
                SportsApp(screenSize = WindowWidthSizeClass.Expanded)
            }
        }
    }
}
