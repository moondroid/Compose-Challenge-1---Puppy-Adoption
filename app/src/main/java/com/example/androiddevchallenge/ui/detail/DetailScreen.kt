package com.example.androiddevchallenge.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.INITIAL_PUPPIES
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.ui.theme.typography
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun DetailScreen(
    id: Int
) {
    Scaffold(
        topBar = {
            val title = stringResource(id = R.string.app_name)
            TopAppBar(
                title = { Text(text = title) },
                navigationIcon = {
                    IconButton(
                        onClick = {}) {
                        Icon(Icons.Filled.ArrowBack, "back")
                    }
                }
            )
        },
        content = { _ ->
            PuppyDetail(INITIAL_PUPPIES[id])
        }
    )
}

@Composable
fun PuppyDetail(
    puppy: Puppy
) {
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CoilImage(
            data = "https://loremflickr.com/320/240/puppy?lock=${puppy.id}",
            contentDescription = puppy.name,
            modifier = Modifier
                .height(180.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(6.dp)),
            contentScale = ContentScale.Crop,
            loading = {
                Image(painterResource(R.drawable.puppy_detail_placeholder), puppy.name)
            },
            error = {
                Image(painterResource(R.drawable.puppy_detail_placeholder), puppy.name)
            },
            fadeIn = true
        )
        Spacer(Modifier.height(16.dp))

        Text(
            puppy.name,
            style = typography.h6,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            "Davenport, California",
            style = typography.body2
        )
        Text(
            "December 2018",
            style = typography.body2
        )
    }
}

@Preview("Detail Screen", widthDp = 360, heightDp = 640)
@Composable
fun DetailScreenPreview() {
    DetailScreen(0)
}