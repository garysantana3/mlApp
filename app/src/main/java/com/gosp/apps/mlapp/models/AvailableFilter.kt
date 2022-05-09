package com.gosp.apps.mlapp.models

data class AvailableFilter(
    val id: String,
    val name: String,
    val type: String,
    val values: List<Value>
)