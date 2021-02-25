package com.example.androiddevchallenge.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.INITIAL_PUPPIES
import com.example.androiddevchallenge.model.Puppy

@Composable
fun DetailScreen(
    id: Int
) {
    Scaffold(
        topBar = {
            val title = stringResource(id = R.string.app_name)
            TopAppBar(
                title = { Text(text = title) }
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

    Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = puppy.name, style = MaterialTheme.typography.h4)
    }
}

@Preview("Detail Screen", widthDp = 360, heightDp = 640)
@Composable
fun DetailScreenPreview(){
    DetailScreen(0)
}