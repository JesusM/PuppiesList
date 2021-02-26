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
package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.ui.components.list.PuppyListItem
import com.example.androiddevchallenge.ui.viewmodel.PuppiesListViewModel
import com.example.androiddevchallenge.ui.viewmodel.Puppy

@Composable
fun PuppyList(
    navController: NavController,
    modifier: Modifier = Modifier,
    puppiesViewModel: PuppiesListViewModel = viewModel()
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Puppies List") },
            )
        }
    ) {
        val puppyCollection = puppiesViewModel.puppiesList.observeAsState(initial = emptyList())
        PuppyList(
            puppyCollection.value,
            { puppy ->
                navController.navigate("details/${puppy.id}")
            },
            modifier
        )
    }
}

@Composable
private fun PuppyList(
    collection: List<Puppy>,
    onPuppyClick: (Puppy) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier,
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(collection) { puppyItem ->
            PuppyListItem(
                onPuppyClick,
                puppyItem
            )
        }
    }
}
