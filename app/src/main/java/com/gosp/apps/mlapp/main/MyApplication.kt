package com.gosp.apps.mlapp.main

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ProcessLifecycleOwner
import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp
import java.text.NumberFormat
import java.util.*

@HiltAndroidApp
class MyApplication:  LifecycleObserver, MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
    }
}

fun Double.asMoneyFormat() : String {
    val amount = NumberFormat.getCurrencyInstance(Locale("es", "MX")).format((this))
    return StringBuilder().append(amount.toString()).toString()
}