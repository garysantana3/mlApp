package com.gosp.apps.mlapp.api

import com.gosp.apps.mlapp.api.response.ItemDetailResponse
import com.gosp.apps.mlapp.api.response.SearchListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MercadoApiClient {

    @GET(Endpoints.SEARCH_PRODUCTS)
    suspend fun searchProducts(
        @Query("q") id_name: String
    ) : Response<SearchListResponse>

    @GET(Endpoints.PRODUCT_DETAIL)
    suspend fun productDetail(
        @Path("id_item") id_item: String
    ) : Response<ItemDetailResponse>
}