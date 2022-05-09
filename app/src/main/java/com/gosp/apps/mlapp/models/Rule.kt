package com.gosp.apps.mlapp.models

data class Rule(
    val default: Boolean,
    val free_mode: String,
    val free_shipping_flag: Boolean,
    val value: Any
)