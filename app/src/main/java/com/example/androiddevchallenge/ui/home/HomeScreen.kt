package com.example.androiddevchallenge.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Puppy
import dev.chrisbanes.accompanist.coil.CoilImage

const val COLUMNS = 2

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

    val rowList = puppies.chunked(COLUMNS)
    LazyColumn(contentPadding = PaddingValues(16.dp)) {

        itemsIndexed(rowList) { index, row ->

            Row(modifier = Modifier.fillMaxWidth()) {
                row.forEachIndexed { index, puppy ->
                    Box(
                        Modifier
                            .weight(1f, fill = true)
                    ){
                        PuppyItem(puppy = puppy, onPuppyClicked = onPuppyClicked)
                    }
                    if (index != row.size - 1) Spacer(Modifier.width(16.dp))
                }
            }
            if (index != rowList.size - 1) Spacer(Modifier.height(16.dp))
        }
    }
}

@Composable
fun PuppyItem(
    puppy: Puppy,
    onPuppyClicked: (Int) -> Unit
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.surface,
        elevation = 4.dp,
        modifier = Modifier.fillMaxWidth().height(160.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .clickable { onPuppyClicked(puppy.id) }
                // .padding(8.dp)
        ) {
            CoilImage(
                data = "https://loremflickr.com/320/160/puppy?random=${puppy.id}&lock=${puppy.id}",
                contentDescription = puppy.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                    // .size(50.dp)
                    // .clip(shape = CircleShape),
                contentScale = ContentScale.Crop,
                alignment =  Alignment.Center,
                    loading = {
                    Image(painterResource(R.drawable.puppy_item_placeholder), puppy.name)
                },
                error = {
                    Image(painterResource(R.drawable.puppy_item_placeholder), puppy.name)
                }
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = puppy.name,
                style = MaterialTheme.typography.subtitle1.copy(color = MaterialTheme.colors.primaryVariant)
            )
            Text(
                text = "${puppy.age} - ${puppy.breed}",
                style = MaterialTheme.typography.caption
            )
        }
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

