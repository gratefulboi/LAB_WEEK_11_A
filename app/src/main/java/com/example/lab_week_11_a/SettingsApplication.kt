package com.example.lab_week_11_a

import android.app.Application

class SettingsApplication : Application() {
    lateinit var settingsStore: SettingsStore
    override fun onCreate() {
        super.onCreate()

        // Initialize settings store
        // Setting store yang dipakai untuk akses data store
        settingsStore = SettingsStore(this)
    }
}