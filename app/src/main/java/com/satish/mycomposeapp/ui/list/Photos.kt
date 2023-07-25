package com.satish.mycomposeapp.ui.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.satish.mycomposeapp.MainViewModel
import com.satish.mycomposeapp.model.Photos


/**
 * Created by Satish V on 14/07/23.
 * Company : HighOnSwift pvt Ltd
 * Email Id : iamsatishema@gmail.com
 */
@Composable
fun PhotosItem(
    photos: Photos,
    onItemClick: (Photos) -> Unit
) {
    Surface(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickable { onItemClick(photos) }
                .height(IntrinsicSize.Min) // Set the Row height to match the content
        ) {
            Image(
                painter = rememberAsyncImagePainter(photos.thumbnailUrl),
                contentDescription = null,
                modifier = Modifier
                    .size(56.dp) // Set a fixed size for the Image
                    .aspectRatio(1f), // Maintain a square aspect ratio for the Image
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = photos.title,
                style = MaterialTheme.typography.body1, // Use a smaller font size
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun PhotosScreen(
    vm: MainViewModel,
    onItemClick: (Photos) -> Unit
) {
    LaunchedEffect(Unit) {
        vm.getPhotosList()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row {
                        Text("Photos")
                    }
                }
            )
        },
        content = { paddingValues ->
            if (vm.errorMessage.isEmpty()) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                        .padding(paddingValues)
                ) {
                    item {
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                    items(vm.photosList) { photo ->
                        PhotosItem(photos = photo, onItemClick = onItemClick)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
            } else {
                Text(vm.errorMessage)
            }
        }
    )
}