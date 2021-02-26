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

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.viewmodel.Puppy

@Composable
fun PuppyDetailCard(
    modifier: Modifier = Modifier,
    puppy: Puppy
) {
    Column(modifier = modifier.padding(16.dp)) {
        Column {
            Text(
                puppy.name, style = MaterialTheme.typography.h5,
                modifier = Modifier
                    .semantics {
                        contentDescription = "Puppy name"
                    }
                    .padding(bottom = 8.dp)
            )
            Text(
                text = puppy.description,
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .semantics {
                        contentDescription = "Puppy detail description"
                    }
                    .padding(bottom = 8.dp)
            )
            Text(
                text = "Breed: ${puppy.breed}",
                style = MaterialTheme.typography.body2,
                modifier = Modifier
                    .semantics {
                        contentDescription = "Puppy breed"
                    }
                    .padding(bottom = 8.dp)
            )

            Text(
                text = "Age: ${puppy.age}",
                style = MaterialTheme.typography.body2,
                modifier = Modifier
                    .semantics {
                        contentDescription = "Puppy age"
                    }
                    .padding(bottom = 8.dp)
            )
        }
    }
}

@Composable
@Preview
fun PuppyDetailCardPreview() {
    val puppy = Puppy(
        "1",
        "Puppy 1",
        "https://images.dog.ceo/breeds/frise-bichon/6.jpg",
        "Such a cute puppy",
        "frise-bichon",
        1
    )
    PuppyDetailCard(modifier = Modifier.fillMaxWidth(), puppy = puppy)
}
