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
package com.example.androiddevchallenge.ui.components.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.viewmodel.Puppy

@Composable
fun PuppyListItem(
    onPuppyClick: (Puppy) -> Unit,
    puppy: Puppy
) {
    Card(
        shape = RoundedCornerShape(3.dp),
        elevation = 6.dp,
        modifier = Modifier
            .clearAndSetSemantics {
                contentDescription = "Puppy ${puppy.name} card."
            }
            .clickable(
                onClick = {
                    onPuppyClick(puppy)
                }
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 8.dp),
        ) {
            PuppyListItemImage(
                imageUrl = puppy.image, imageLabel = puppy.id,
                modifier = Modifier
                    .size(90.dp)
            )

            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(8.dp)
            ) {
                Text(
                    text = puppy.name,
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.h6
                )
                Text(
                    text = puppy.description,
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.body1
                )
            }
        }
    }
}

@Preview("Puppy list card")
@Composable
fun PuppyListItemPreview() {
    PuppyListItem(
        onPuppyClick = { },
        puppy = Puppy(
            "1",
            "Puppy 1",
            "https://images.dog.ceo/breeds/frise-bichon/6.jpg",
            "Such a cute puppy",
            "frise-bichon",
            1
        )
    )
}
