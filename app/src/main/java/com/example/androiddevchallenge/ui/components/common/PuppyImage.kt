/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.components.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntSize
import coil.request.ImageRequest
import com.example.androiddevchallenge.R
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun PuppyImage(
    imageUrl: String,
    imageLabel: String,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    requestBuilder: (ImageRequest.Builder.(size: IntSize) -> ImageRequest.Builder)? = null
) {
    CoilImage(
        data = imageUrl,
        modifier = modifier,
        contentScale = ContentScale.Crop,
        loading = {
            Box(Modifier.matchParentSize()) {
                CircularProgressIndicator(Modifier.align(Alignment.Center))
            }
        },
        error = {
            Image(
                painter = painterResource(R.drawable.ic_baseline_face_24),
                contentDescription = contentDescription ?: "Image $imageLabel error image."
            )
        },
        contentDescription = contentDescription ?: "$imageLabel image.",
        requestBuilder = requestBuilder
    )
}
