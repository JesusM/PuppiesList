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

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import kotlin.math.max
import kotlin.math.min

private val CollapsedImageSize = 50.dp

@Composable
fun CollapsingImageLayout(
    collapseFraction: Float,
    modifier: Modifier = Modifier,
    initialImageMaxSize: Dp,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content
    ) { measurables, constraints ->
        check(measurables.size == 1)
        val imageMaxHeight = min(initialImageMaxSize.toPx().toInt(), constraints.maxWidth)
        val imageMinHeight = max(CollapsedImageSize.toPx().toInt(), constraints.minWidth)
        val imageHeight =
            lerp(imageMaxHeight.toDp(), imageMinHeight.toDp(), collapseFraction).toPx().toInt()
        val imagePlaceable =
            measurables[0].measure(Constraints.fixed(constraints.maxWidth, imageHeight))

        val imageY = lerp(0.dp, imageMaxHeight.toDp(), collapseFraction).toPx().toInt()
        layout(
            width = constraints.maxWidth,
            height = imageHeight
        ) {
            imagePlaceable.place(0, imageY)
        }
    }
}
