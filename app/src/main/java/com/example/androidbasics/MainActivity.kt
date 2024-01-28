package com.example.androidbasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidbasics.ui.theme.AndroidBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidBasicsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard(
                        name = getString(R.string.dev_name),
                        title = getString(R.string.dev_title),
                        number = getString(R.string.dev_phone),
                        username = getString(R.string.dev_username),
                        email = getString(R.string.dev_email)
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingsImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.androidparty)
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
        GreetingText(
            message, from, modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .padding(8.dp)
            .background(Color.Transparent)
    ) {
        Text(
            text = message,
            fontSize = 80.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center,
            color = Color.Black
        )
        Text(
            text = from,
            fontSize = 36.sp,
            color = Color.Black,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = false)
@Composable
fun BirthdateCardPreview() {
    AndroidBasicsTheme {
        GreetingsImage(
            message = "Happy Birthday Rob!", from = "From Android"
        )
    }
}

@Composable
fun BusinessCard(
    name: String,
    title: String,
    number: String,
    username: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .background(Color(0xFFc1e5cb))
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,
            modifier = modifier
                .padding(top = 20.dp, bottom = 100.dp)
        ) {
            BusinessLogo(modifier)
            Text(
                text = name,
                fontSize = 30.sp,
                fontStyle = FontStyle.Italic,
                modifier = modifier.padding(5.dp)
            )
            Text(
                text = title,
                color = Color(0xFF162807),
                fontWeight = FontWeight.Bold,
                 modifier = modifier.padding(5.dp)
            )
        }
        ContactText(number, username, email, modifier)
    }
}

@Composable
fun BusinessLogo(modifier: Modifier) {
    val image = painterResource(id = R.drawable.android_logo)
    Image(
        painter = image,
        contentDescription = stringResource(R.string.android_logo),
        modifier = modifier
            .padding(8.dp)
            .background(color = Color(0xFF001933))
            .size(80.dp)
    )
}

@Composable
fun ContactText(
    number: String,
    username: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(horizontalAlignment = Alignment.Start) {
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = modifier.padding(vertical = 10.dp, horizontal = 80.dp)
        ) {
            Icon(
                imageVector = Icons.Rounded.Call,
                contentDescription = null,
                tint = Color(0xFF162807),
                modifier = modifier.padding(end = 20.dp)
            )
            Text(text = number, color = Color(0xFF162807))
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier.padding(vertical = 10.dp, horizontal = 80.dp)
        ) {
            Icon(
                imageVector = Icons.Rounded.Share,
                contentDescription = null,
                tint = Color(0xFF162807),
                modifier = modifier.padding(end = 20.dp)
            )
            Text(text = username)
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier.padding(vertical = 10.dp, horizontal = 80.dp)
        ) {
            Icon(
                imageVector = Icons.Rounded.Email,
                contentDescription = null,
                tint = Color(0xFF162807),
                modifier = modifier.padding(end = 20.dp)
            )
            Text(text = email)
        }
    }

}

@Preview(showBackground = false)
@Composable
fun BusinessGreetingCardPreview() {
    AndroidBasicsTheme {
        BusinessCard(
            name = "Roberto Hamano",
            title = "Junior Mobile Software Engineer",
            number = "+55 99 99999-9999",
            username = "@rbrthmn",
            email = "robertokenzohamano@gmail.com"
        )
    }
}