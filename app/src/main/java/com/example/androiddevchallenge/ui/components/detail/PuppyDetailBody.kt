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
package com.example.androiddevchallenge.ui.components.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.components.common.PuppyImage
import com.example.androiddevchallenge.ui.viewmodel.Puppy
import com.marvelsample.app.ui.characterdetails.compose.Up

@Composable
fun PuppyDetailBody(
    puppy: Puppy,
    upPress: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val scroll = rememberScrollState(0)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scroll)
        ) {
            val initialImageMaxSize =
                dimensionResource(R.dimen.collection_item_detail_height)
            val collapseRange = with(LocalDensity.current) { (initialImageMaxSize).toPx() }
            val collapseFraction = (scroll.value / collapseRange).coerceIn(0f, 1f)

            CollapsingImageLayout(
                collapseFraction = collapseFraction,
                modifier = Modifier,
                initialImageMaxSize = initialImageMaxSize
            ) {
                PuppyImage(
                    imageUrl = puppy.image,
                    imageLabel = puppy.name,
                    modifier = Modifier.height(initialImageMaxSize),
                    contentDescription = "Character detail image"
                )
            }
            Surface {
                Column {
                    PuppyDetailCard(puppy = puppy)
                }
            }
        }
        Up(upPress)
    }
}

@Preview
@Composable
fun PuppyDetailBodyPreview() {
    PuppyDetailBody(
        puppy = Puppy(
            "1",
            "Puppy 1",
            "https://images.dog.ceo/breeds/frise-bichon/6.jpg",
            "Such a cute puppy",
            "frise-bichon",
            1
        ),
        upPress = { }
    )
}
