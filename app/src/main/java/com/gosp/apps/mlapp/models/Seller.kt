package com.gosp.apps.mlapp.models

data class Seller(
    val car_dealer: Boolean,
    val eshop: Eshop,
    val id: String,
    val permalink: String,
    val real_estate_agency: Boolean,
    val registration_date: String,
    val seller_reputation: SellerReputation,
    val tags: List<String>
)