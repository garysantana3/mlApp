package com.gosp.apps.mlapp.main

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gosp.apps.mlapp.api.MercadoServices
import com.gosp.apps.mlapp.api.response.ItemDetailResponse
import com.gosp.apps.mlapp.mlapp.utils.Enums
import com.gosp.apps.mlapp.models.ItemsResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val services: MercadoServices) : ViewModel()  {


    // Create a LiveData
    val viewState: MutableLiveData<Enums.ViewStates> by lazy {
        MutableLiveData<Enums.ViewStates>()
    }

    var dataList = MutableLiveData<ArrayList<ItemsResult>>()
    var detailItemData = MutableLiveData<ItemDetailResponse>()
    var isBatInternet = false

    init {
        viewState.value = Enums.ViewStates.SEARCH
        isBatInternet = false
    }

    fun changeState(state : Enums.ViewStates) {
        viewModelScope.launch {
            viewState.value = state
        }
    }

    fun doSearch(product: String,context: Context){
        viewModelScope.launch {
            try {
                if (!checkInternetOn(context)){
                    changeState(Enums.ViewStates.NOT_INTERNET)
                } else {
                    val searchList = services.getProductsSearch(product)
                    if (searchList != null){
                        dataList.value = searchList?.results
                        changeState(Enums.ViewStates.SEARCH_RESULTS)
                    }else{
                        changeState(Enums.ViewStates.SOMETHING_WRONG)
                    }
                }
            }catch (e:Exception){
                changeState(Enums.ViewStates.SOMETHING_WRONG)
            }
        }
    }

    fun getDetailItem(id: String,context: Context){
        viewModelScope.launch {
            try {
                if (!checkInternetOn(context)){
                    changeState(Enums.ViewStates.NOT_INTERNET)
                } else{
                    val detailData = services.getItemDetail(id)
                    if (detailData != null){
                        detailItemData.value = detailData!!
                        changeState(Enums.ViewStates.PRODUCT_DETAIL)
                    }else{
                        changeState(Enums.ViewStates.SOMETHING_WRONG)
                    }
                }
            }catch (e:Exception){
                changeState(Enums.ViewStates.SOMETHING_WRONG)
            }
        }
    }

    private fun checkInternetOn(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val internetInfo = cm.activeNetworkInfo
        return internetInfo!=null && internetInfo.isConnected
    }
}