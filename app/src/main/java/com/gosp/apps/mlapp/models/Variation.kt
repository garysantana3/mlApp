package com.gosp.apps.mlapp.models

data class Variation(
    val attribute_combinations: List<AttributeCombination>,
    val available_quantity: String,
    val catalog_product_id: String,
    val id: String,
    val picture_ids: List<String>,
    val price: String,
    val sale_terms: List<Any>,
    val sold_quantity: String
)