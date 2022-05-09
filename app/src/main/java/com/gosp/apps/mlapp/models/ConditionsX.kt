package com.gosp.apps.mlapp.models

data class ConditionsX(
    val context_restrictions: List<String>,
    val eligible: Boolean,
    val end_time: Any,
    val start_time: Any
)