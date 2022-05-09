package com.gosp.apps.mlapp.models

data class AttributeX(
    val attribute_group_id: String,
    val attribute_group_name: String,
    val id: String,
    val name: String,
    val value_id: String,
    val value_name: String,
    val value_struct: Any,
    val valueYS: List<ValueY>
)