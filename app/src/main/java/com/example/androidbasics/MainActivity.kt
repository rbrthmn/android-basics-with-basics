package com.example.androidbasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidbasics.ui.theme.AndroidBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidBasicsTheme(darkTheme = false) {
                ArtGalleryLayout()
            }
        }
    }

    @Preview
    @Composable
    fun ArtGalleryLayout(modifier: Modifier = Modifier) {
        val art1 = ArtPiece(
            imageId = R.drawable.art_street_light,
            artistName = stringResource(R.string.art1_artist_name),
            artName = stringResource(R.string.art1_name),
            artYear = stringResource(R.string.art1_year)
        )
        val art2 = ArtPiece(
            imageId = R.drawable.art_houses,
            artistName = stringResource(R.string.art2_artist_name),
            artName = stringResource(R.string.art2_name),
            artYear = stringResource(R.string.art2_year)
        )
        val art3 = ArtPiece(
            imageId = R.drawable.art_bask,
            artistName = stringResource(R.string.art3_artist_name),
            artName = stringResource(R.string.art3_name),
            artYear = stringResource(R.string.art3_year)
        )
        val art4 = ArtPiece(
            imageId = R.drawable.art_coffe_cup,
            artistName = stringResource(R.string.art4_artist_name),
            artName = stringResource(R.string.art4_name),
            artYear = stringResource(R.string.art4_year)
        )
        val artPieces = listOf(art1, art2, art3, art4)
        var currentArt by remember { mutableIntStateOf(0) }

        Surface(modifier = modifier.fillMaxSize()) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = modifier.verticalScroll(rememberScrollState())
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = modifier.padding(top = 40.dp)
                ) {
                    ArtImage(
                        imageId = artPieces[currentArt].imageId,
                        imageName = artPieces[currentArt].artName,
                        modifier = modifier
                    )
                    ArtistInfo(
                        artName = artPieces[currentArt].artName,
                        artistName = artPieces[currentArt].artistName,
                        artYear = artPieces[currentArt].artYear,
                        modifier = modifier
                    )
                }
                ActionButtons(onNextAction = {
                    if (currentArt == artPieces.lastIndex) {
                        currentArt = 0
                    } else currentArt++
                }, onPreviousAction = {
                    if (currentArt == 0) {
                        currentArt = artPieces.lastIndex
                    } else currentArt--
                }, modifier = modifier)
            }
        }
    }

    @Composable
    fun ArtImage(imageId: Int, imageName: String, modifier: Modifier) {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = "Description of $imageName",
            contentScale = ContentScale.FillWidth,
            modifier = modifier
                .padding(horizontal = 30.dp)
                .background(color = Color.Yellow)
                .shadow(elevation = 10.dp)
                .border(width = 30.dp, color = Color.White)
        )
    }

    @Composable
    fun ArtistInfo(artName: String, artistName: String, artYear: String, modifier: Modifier) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = modifier
                .padding(30.dp)
                .border(width = 10.dp, color = Color.Transparent)
        ) {
            Text(
                text = artName,
                fontSize = 30.sp,
                fontWeight = FontWeight.Thin,
                fontStyle = FontStyle.Italic,
                modifier = modifier
                    .background(color = Color.LightGray)
                    .padding(start = 10.dp, end = 10.dp, bottom = 1.dp, top = 10.dp)
                    .fillMaxWidth()
            )
            Row(
                modifier = modifier
                    .background(color = Color.LightGray)
                    .padding(start = 10.dp, end = 10.dp, bottom = 10.dp, top = 1.dp)
                    .fillMaxWidth()
            ) {
                Text(text = artistName, fontWeight = FontWeight.Bold)
                Spacer(modifier = modifier.width(5.dp))
                Text(text = "($artYear)")
            }
        }
    }

    @Composable
    fun ActionButtons(onPreviousAction: () -> Unit, onNextAction: () -> Unit, modifier: Modifier) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 5.dp)
        ) {
            Button(onClick = { onPreviousAction() }) {
                Text(text = stringResource(id = R.string.previous))
            }
            Button(onClick = { onNextAction() }) {
                Text(text = stringResource(id = R.string.next))
            }
        }
    }
}

data class ArtPiece(
    val imageId: Int,
    val artName: String,
    val artistName: String,
    val artYear: String
)
