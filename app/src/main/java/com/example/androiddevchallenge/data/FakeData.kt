package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.model.Puppy

private val PUPPY_NAMES: List<String> = listOf(
    "Zorro", "Zack", "Chewbacca", "Gromit", "Clue", "Bandit", "Loki", "Thor", "Hunter", "Hoppity", "Tommy"
)

private val PUPPY_GENDERS: List<String> = listOf(
    "Male", "Female"
)

private val PUPPY_SIZES: List<String> = listOf(
    "Small", "Medium", "Large", "xLarge"
)

private val PUPPY_AGES: List<String> = listOf(
    "Baby", "Young", "Adult", "Senior"
)

private val PUPPY_BREEDS: List<String> = listOf(
    "Chow Chow", "Husky", "German Shepherd", "Pit Bull Terrier", "Labrador Retriever", "Mixed Breed"
)

val INITIAL_PUPPIES: List<Puppy> = List(30) {
    Puppy(
        it,
        PUPPY_NAMES.random(),
        PUPPY_AGES.random(),
        PUPPY_GENDERS.random(),
        PUPPY_BREEDS.random(),
        PUPPY_SIZES.random()
    )
}



