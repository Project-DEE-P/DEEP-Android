package com.example.app.di

import android.app.Application
import com.example.data.utils.PreferencesManager
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HiltApplication : Application() {

    companion object {
        lateinit var pref: PreferencesManager
    }

    override fun onCreate() {
        pref = PreferencesManager(applicationContext)
        super.onCreate()
    }

}