package com.gosp.apps.mlapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.*
import androidx.lifecycle.Observer
import com.gosp.apps.mlapp.main.MainViewModel
import com.gosp.apps.mlapp.mlapp.utils.Enums
import com.gosp.apps.mlapp.ui.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(),LifecycleObserver {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.viewState.observe(this, Observer {  t -> changeView(t) })
    }

    private fun changeView(state: Enums.ViewStates){
        when (state) {
                Enums.ViewStates.SEARCH -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, SearchFragment.newInstance())
                        .commit()

                }
                Enums.ViewStates.SEARCH_RESULTS -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.container, SearchResultFragment.newInstance())
                        .addToBackStack("search_result")
                        .commit()

                }
                Enums.ViewStates.PRODUCT_DETAIL -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, ProductDetailFragment.newInstance())
                        .addToBackStack("product_detail")
                        .commit()
                }
                Enums.ViewStates.SOMETHING_WRONG -> {
                    viewModel.isBatInternet = false
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, SomethingWrongFragment.newInstance())
                        .addToBackStack("something_wrong")
                        .commit()
                }
                Enums.ViewStates.NOT_INTERNET -> {
                    viewModel.isBatInternet = true
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, SomethingWrongFragment.newInstance())
                        .addToBackStack("not_internet")
                        .commit()
                }
            }
    }
}