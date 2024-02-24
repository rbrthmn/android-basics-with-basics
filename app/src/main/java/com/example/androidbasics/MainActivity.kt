package com.example.androidbasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidbasics.ui.theme.AndroidBasicsTheme
import com.example.androidbasics.unit3.DataSource
import com.example.androidbasics.unit3.model.Topic

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidBasicsTheme(darkTheme = false) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TopicApp()
                }
            }
        }
    }

    @Preview
    @Composable
    fun TopicApp(modifier: Modifier = Modifier) {
        TopicsList(topics = DataSource.topics, modifier = modifier)
    }

    @Composable
    fun TopicsList(topics: List<Topic>, modifier: Modifier) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier.fillMaxWidth().padding(8.dp)
        ) {
            items(topics) { topic ->
                TopicCard(topic = topic, modifier = modifier)
            }
        }
    }

    @Composable
    fun TopicCard(topic: Topic, modifier: Modifier) {
        Card(modifier = modifier) {
            Row(modifier = modifier.height(68.dp)) {
                Image(
                    painter = painterResource(id = topic.imageResourceId),
                    contentDescription = stringResource(id = topic.stringResourceId),
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .size(width = 68.dp, height = 68.dp)
                        .aspectRatio(1F)
                )
                Column(modifier = modifier.padding(horizontal = 16.dp)) {
                    Text(
                        text = stringResource(id = topic.stringResourceId),
                        overflow = TextOverflow.Ellipsis,
                        modifier = modifier.padding(top = 16.dp, bottom = 8.dp)
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_grain),
                            contentDescription = null
                        )
                        Text(
                            text = topic.coursesNumber.toString(),
                            style = MaterialTheme.typography.labelMedium,
                            modifier = modifier.padding(start = 8.dp)
                        )
                    }
                }
            }
        }
    }
}

