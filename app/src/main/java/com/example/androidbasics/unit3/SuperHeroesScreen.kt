package com.example.androidbasics.unit3

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidbasics.R
import com.example.androidbasics.ui.theme.SuperheroesTheme
import com.example.androidbasics.unit3.model.Hero
import com.example.androidbasics.unit3.repository.HeroesRepository

class SuperHeroesScreen {

    @Composable
    fun SuperHeroesApp(modifier: Modifier = Modifier) {
        SuperheroesTheme {
            Scaffold(topBar = { HeroesAppBar() }) { it ->
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    LazyColumn(contentPadding = it) {
                        items(HeroesRepository.heroes) {
                            HeroItem(hero = it, modifier = modifier)
                        }
                    }
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun HeroesAppBar(modifier: Modifier = Modifier) {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = stringResource(R.string.heroApp),
                    style = MaterialTheme.typography.displayLarge
                )
            }, modifier = modifier
        )
    }

    @Composable
    fun HeroItem(hero: Hero, modifier: Modifier) {
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            shape = MaterialTheme.shapes.medium,
            modifier = modifier.padding(16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier
                    .sizeIn(minHeight = 72.dp)
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Column(
                    verticalArrangement = Arrangement.Top,
                    modifier = modifier
                        .fillMaxHeight()
                        .weight(1f)
                ) {
                    Text(
                        text = stringResource(id = hero.nameRes),
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = stringResource(id = hero.descriptionRes),
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                Spacer(Modifier.width(16.dp))
                Image(
                    painter = painterResource(id = hero.imageRes),
                    contentDescription = stringResource(id = hero.nameRes),
                    modifier = modifier
                        .height(72.dp)
                        .width(72.dp)
                        .clip(MaterialTheme.shapes.small)
                )
            }
        }
    }

    @Preview
    @Composable
    fun SuperHeroesPreview() {
        SuperHeroesApp()
    }
}