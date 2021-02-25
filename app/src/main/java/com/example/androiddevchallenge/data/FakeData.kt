package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.model.Puppy

val INITIAL_PUPPIES: List<Puppy> = List(30){
    Puppy(it, "Puppy ${it + 1}")
}