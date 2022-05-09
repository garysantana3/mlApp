package com.gosp.apps.mlapp.models

data class Filter(
    val id: String,
    val name: String,
    val type: String,
    val values: List<ValueX>
)