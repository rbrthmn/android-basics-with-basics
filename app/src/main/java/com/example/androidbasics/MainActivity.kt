package com.example.androidbasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidbasics.ui.theme.AndroidBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidBasicsTheme {
                LemonadeApp()
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun LemonadeApp(modifier: Modifier = Modifier) {
        var currentStep by remember { (mutableIntStateOf(1)) }
        var squeezeTimes = 0
        var necessarySqueezeTimes = (2..4).random()
        Scaffold(topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Lemonade", fontWeight = FontWeight.Bold) },
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                ),
            )
        }) {
            when (currentStep) {
                1 -> LemonImageWithText(
                    modifier = modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                        .background(Color.White),
                    padding = it,
                    imageId = R.drawable.lemon_tree,
                    textId = R.string.lemonade_1,
                    onClickAction = {
                        currentStep++
                        necessarySqueezeTimes = (2..4).random()
                    }
                )

                2 -> LemonImageWithText(
                    modifier = modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                        .background(Color.White),
                    padding = it,
                    imageId = R.drawable.lemon_squeeze,
                    textId = R.string.lemonade_2,
                    onClickAction = {
                        squeezeTimes++
                        if (squeezeTimes == necessarySqueezeTimes) {
                            currentStep++
                            squeezeTimes = 0
                        }
                    }
                )

                3 -> LemonImageWithText(
                    modifier = modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                        .background(Color.White),
                    padding = it,
                    imageId = R.drawable.lemon_drink,
                    textId = R.string.lemonade_3,
                    onClickAction = { currentStep++ }
                )

                4 -> LemonImageWithText(
                    modifier = modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                        .background(Color.White),
                    padding = it,
                    imageId = R.drawable.lemon_restart,
                    textId = R.string.lemonade_2,
                    onClickAction = { currentStep = 1 }
                )

                else -> LemonImageWithText(
                    modifier = modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                        .background(Color.White),
                    padding = it,
                    imageId = R.drawable.lemon_tree,
                    textId = R.string.lemonade_1,
                    onClickAction = { currentStep++ }
                )
            }
        }


    }

    @Composable
    fun LemonImageWithText(
        modifier: Modifier,
        padding: PaddingValues,
        imageId: Int = R.drawable.lemon_tree,
        textId: Int = R.string.lemonade_1,
        onClickAction: () -> Unit
    ) {
        Surface(
            modifier = modifier.padding(padding),
            color = Color.Black,
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = modifier.fillMaxSize()
            ) {
                Button(
                    onClick = { onClickAction() },
                    shape = AbsoluteRoundedCornerShape(size = 24.dp),
                    colors = ButtonDefaults.outlinedButtonColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)
                ) {
                    Image(
                        painter = painterResource(id = imageId),
                        contentDescription = null
                    )
                }
                Text(
                    text = stringResource(id = textId),
                    fontSize = 18.sp,
                )
            }
        }
    }

    @Preview
    @Composable
    fun LemonadeMakerPreview(modifier: Modifier = Modifier) {
        LemonadeApp(modifier)
    }
}
