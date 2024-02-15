package com.example.androidbasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.androidbasics.ui.theme.AndroidBasicsTheme
import com.example.androidbasics.unit2.TipCalculator

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidBasicsTheme {
                TipCalculator().TipCalculatorLayout()
            }
        }
    }
}
