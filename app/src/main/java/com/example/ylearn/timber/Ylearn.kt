package com.example.ylearn.timber

import android.app.Application
import timber.log.Timber

class Ylearn : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}