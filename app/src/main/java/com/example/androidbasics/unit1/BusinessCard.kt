package com.example.androidbasics.unit1

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidbasics.R
import com.example.androidbasics.ui.theme.AndroidBasicsTheme

class BusinessCard {

    @SuppressLint("NotConstructor")
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
}
