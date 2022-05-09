package com.gosp.apps.mlapp.models

data class SellerReputation(
    val level_id: String,
    val metrics: Metrics,
    val power_seller_status: String,
    val transactions: Transactions
)