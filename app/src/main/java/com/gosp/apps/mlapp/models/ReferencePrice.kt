package com.gosp.apps.mlapp.models

data class ReferencePrice(
    val amount: String,
    val conditions: ConditionsX,
    val currency_id: String,
    val exchange_rate_context: String,
    val id: String,
    val last_updated: String,
    val tags: List<Any>,
    val type: String
)