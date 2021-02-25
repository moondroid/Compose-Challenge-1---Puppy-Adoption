package com.example.androiddevchallenge.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Puppy

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
            Divider(color = Color.Gray)
        }
    }
}

@Composable
fun PuppyItem(
    puppy: Puppy,
    onPuppyClicked: (Int) -> Unit
) {
    Text(text = puppy.name,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onPuppyClicked(puppy.id) }
            .padding(16.dp))
}


@Preview("Home Screen", widthDp = 360, heightDp = 640)
@Composable
fun HomeScreenPreview(){
    HomeScreen(puppies = listOf(Puppy(0, "Cat"), Puppy(1, "Dog")), {})
}