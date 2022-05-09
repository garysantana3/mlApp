package com.gosp.apps.mlapp.models

data class Paging(
    val limit: String,
    val offset: String,
    val primary_results: String,
    val total: String
)