package com.example.androidbasics.unit3

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidbasics.R
import com.example.androidbasics.unit3.data.Datasource
import com.example.androidbasics.unit3.model.Affirmation

class AffirmationApp {

    @Composable
    fun AffirmationsApp() {
        AffirmationList(
            affirmationList = Datasource.loadAffirmations(),
        )
    }

    @Composable
    fun AffirmationList(affirmationList: List<Affirmation>, modifier: Modifier = Modifier) {
        LazyColumn(modifier = modifier) {
            items(affirmationList) {
                AffirmationCard(affirmation = it, modifier = modifier.padding(8.dp))
            }
        }
    }

    @Preview
    @Composable
    private fun AffirmationListPreview() {
        AffirmationList(affirmationList = Datasource.loadAffirmations(), modifier = Modifier)
    }

    @Composable
    fun AffirmationCard(affirmation: Affirmation, modifier: Modifier = Modifier) {
        Card(modifier = modifier) {
            Column {
                Image(
                    painter = painterResource(id = affirmation.imageResourceId),
                    contentDescription = stringResource(id = affirmation.stringResourceId),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(194.dp),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = LocalContext.current.getString(affirmation.stringResourceId),
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.headlineSmall
                )
            }
        }
    }

    @Preview
    @Composable
    private fun AffirmationCardPreview() {
        AffirmationCard(
            affirmation =
            Affirmation(R.string.affirmation1, R.drawable.image1)
        )
    }
}