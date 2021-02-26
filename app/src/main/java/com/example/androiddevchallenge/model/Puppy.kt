package com.example.androiddevchallenge.model

data class Puppy(
    val id: Int,
    val name: String,
    val age: String = "",
    val gender: String = "",
    val breed: String = "",
    val size: String = ""
)