package com.gosp.apps.mlapp.models

data class ShippingX(
    val dimensions: Any,
    val free_methods: List<FreeMethod>,
    val free_shipping: Boolean,
    val local_pick_up: Boolean,
    val logistic_type: String,
    val mode: String,
    val store_pick_up: Boolean,
    val tags: List<String>
)