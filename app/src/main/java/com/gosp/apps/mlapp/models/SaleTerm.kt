package com.gosp.apps.mlapp.models

data class SaleTerm(
    val id: String,
    val name: String,
    val value_id: String,
    val value_name: String,
    val value_struct: Any,
    val values: List<ValueXY>
)