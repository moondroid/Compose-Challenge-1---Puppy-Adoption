package com.example.androiddevchallenge.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Puppy
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun HomeScreen(
    puppies: List<Puppy>,
    onPuppyClicked: (Int) -> Unit
) {
    Scaffold(
        topBar = {
            val title = stringResource(id = R.string.app_name)
            TopAppBar(
                title = { Text(text = title) }
            )
        },
        content = { _ ->
            PuppyList(puppies, onPuppyClicked)
        }
    )
}

@Composable
fun PuppyList(
    puppies: List<Puppy>,
    onPuppyClicked: (Int) -> Unit
) {

    LazyColumn(modifier = Modifier.padding(horizontal = 16.dp)) {

        items(items = puppies) { puppy ->
            PuppyItem(puppy = puppy, onPuppyClicked = onPuppyClicked)
            // Divider(color = Color.Gray)
        }
    }
}

@Composable
fun PuppyItem(
    puppy: Puppy,
    onPuppyClicked: (Int) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onPuppyClicked(puppy.id) }
            .padding(8.dp)
    ) {
        CoilImage(
            data = "https://loremflickr.com/320/240/puppy?random=${puppy.id}&lock=${puppy.id}",
            contentDescription = puppy.name,
            modifier = Modifier
                .size(50.dp)
                .clip(shape = RoundedCornerShape(8.dp))
        )
        Spacer(Modifier.width(16.dp))
        Text(
            text = puppy.name,
            style = MaterialTheme.typography.subtitle1
        )
    }
}

@Preview("Puppy Item", widthDp = 360, heightDp = 640)
@Composable
fun PuppyItemPreview(){
    PuppyItem(Puppy(0, "Cat"), {})
}

@Preview("Home Screen", widthDp = 360, heightDp = 640)
@Composable
fun HomeScreenPreview(){
    HomeScreen(puppies = listOf(Puppy(0, "Cat"), Puppy(1, "Dog")), {})
}

