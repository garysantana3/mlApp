package com.gosp.apps.mlapp.api.response

import com.gosp.apps.mlapp.models.*

data class SearchListResponse(
   /* val available_filters: List<AvailableFilter>,
    val available_sorts: List<AvailableSort>,
    val country_default_time_zone: String,
    val filters: List<Filter>,
    val paging: Paging,
    val query: String,*/
    val results: ArrayList<ItemsResult>,
    /*val site_id: String,
    val sort: Sort*/
)