package com.satish.mycomposeapp.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.satish.mycomposeapp.R
import com.satish.mycomposeapp.model.Photos


/**
 * Created by Satish V on 14/07/23.
 * Company : HighOnSwift pvt Ltd
 * Email Id : iamsatishema@gmail.com
 */
@Composable
fun PhotoDetailScreen(
    photo: Photos,
    navigateUp: () -> Unit
) {
    val context = LocalContext.current
    SetPhotosDetails(photo, navigateUp)
}

@Composable
fun DetailHeader(
    url: String,
    navigateUp: () -> Unit
) {
    Box {
        Image(
            painter = rememberAsyncImagePainter(model = url),
            contentDescription = stringResource(R.string.content_desc_cat_detail_image),
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp),
            contentScale = ContentScale.Crop
        )
        TopAppBar(
            backgroundColor = Color.Transparent,
            elevation = 0.dp,
            contentColor = Color.White
        ) {
            IconButton(onClick = navigateUp) {
                Icon(
                    imageVector = Icons.Rounded.ArrowBack,
                    contentDescription = stringResource(R.string.content_desc_up_navigate_detail)
                )
            }
        }
    }
}

@Composable
fun PhotosDetailText(text: String) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp)
            ) {
                Text(
                    text,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
        Divider()
    }
}

@Composable
private fun SetPhotosDetails(
    photos: Photos,
    navigateUp: () -> Unit
) {
    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            LazyColumn {
                item { DetailHeader(photos.url, navigateUp) }
                item { PhotosDetailText(photos.id.toString()) }
                item { PhotosDetailText(photos.title) }
                item { PhotosDetailText(photos.albumId.toString()) }
            }
        }
    }
}
