package com.gosp.apps.mlapp.models

data class Transactions(
    val canceled: String,
    val completed: String,
    val period: String,
    val ratings: Ratings,
    val total: String
)