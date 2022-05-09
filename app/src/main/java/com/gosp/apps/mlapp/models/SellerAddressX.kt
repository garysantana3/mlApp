package com.gosp.apps.mlapp.models

data class SellerAddressX(
    val cityXY: CityXY,
    val countryX: CountryX,
    val id: String,
    val search_location: SearchLocation,
    val state: StateX
)