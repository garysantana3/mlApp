package com.gosp.apps.mlapp.api
import com.gosp.apps.mlapp.api.response.ItemDetailResponse
import com.gosp.apps.mlapp.api.response.SearchListResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class MercadoServices @Inject constructor(private val api: MercadoApiClient) {

    suspend fun getProductsSearch(id: String): SearchListResponse? {
        return withContext(Dispatchers.IO) {
            val response = api.searchProducts(id_name = id)
            response.body()
        }
    }

    suspend fun getItemDetail(id_product: String): ItemDetailResponse? {
        return withContext(Dispatchers.IO) {
            val response = api.productDetail(id_item = id_product)
            response.body()
        }
    }
}