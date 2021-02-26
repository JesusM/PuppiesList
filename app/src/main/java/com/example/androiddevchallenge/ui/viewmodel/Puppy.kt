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
package com.example.androiddevchallenge.ui.viewmodel

data class Puppy(
    val id: String,
    val name: String,
    val image: String,
    val description: String,
    val breed: String,
    val age: Int
)

val puppies = listOf(
    Puppy(
        "1",
        "Mya",
        "https://images.dog.ceo/breeds/frise-bichon/6.jpg",
        "This is Mya. She’s been learning to sing the Star Wars theme song. Finally got it at the end there.",
        "frise-bichon",
        1
    ),
    Puppy(
        "2",
        "Wrigley",
        "https://images.dog.ceo/breeds/briard/n02105251_7977.jpg",
        "This is Wrigley. He’s steppin out for a bit if you guys need anything. Tired of nobody seeing his fits.",
        "briard",
        2
    ),
    Puppy(
        "3",
        "Puppy 3",
        "https://images.dog.ceo/breeds/retriever-chesapeake/n02099849_4419.jpg",
        "Such a cute puppy",
        "retriever-chesapeake",
        3
    ),
    Puppy(
        "4",
        "Buster",
        "https://images.dog.ceo/breeds/havanese/00100trPORTRAIT_00100_BURST20191126134713895_COVER.jpg",
        "Such a cute puppy",
        "cockapoo",
        4
    ),
    Puppy(
        "5",
        "Silky",
        "https://images.dog.ceo/breeds/terrier-silky/n02097658_9987.jpg",
        "Such a cute puppy",
        "terrier-silky",
        5
    ),
    Puppy(
        "6",
        "Puppy 6",
        "https://images.dog.ceo/breeds/spaniel-cocker/n02102318_10218.jpg",
        "Such a cute puppy",
        "spaniel-cocker",
        6
    ),
    Puppy(
        "7",
        "Puppy 7",
        "https://images.dog.ceo/breeds/frise-bichon/6.jpg",
        "Such a cute puppy",
        "frise-bichon",
        7
    ),
    Puppy(
        "8",
        "Puppy 8",
        "https://images.dog.ceo/breeds/terrier-american/n02093428_8454.jpg",
        "Such a cute puppy",
        "terrier-american",
        8
    ),
    Puppy(
        "9",
        "Cooper",
        "https://images.dog.ceo/breeds/dalmatian/cooper1.jpg",
        "Such a cute puppy",
        "dalmatian",
        9
    ),
    Puppy(
        "10",
        "Bernard",
        "https://images.dog.ceo/breeds/stbernard/n02109525_2943.jpg",
        "Such a cute puppy",
        "stbernard",
        6
    ),
)
