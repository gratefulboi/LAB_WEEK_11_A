package com.example.lab_week_11_a

import android.app.Application
import android.content.Context

class PreferenceApplication : Application() {
    lateinit var preferenceWrapper: PreferenceWrapper
    override fun onCreate() {
        super.onCreate()

        // Initialize preference wrapper
        // Preference wrapper digunakan buat akses shared preferences
        preferenceWrapper = PreferenceWrapper(
            // Get shared preferences
            // Shared preferences disimpan di file /data/data/com.example.lab_week_11_a/shared_prefs/prefs.xml
            getSharedPreferences(
                // Nama filenya
            "prefs",
                //Mode file nya private, artinya cuman aplikasi yang bisa mengakses sharedpreferences ini
                    Context.MODE_PRIVATE

            )
        )
    }
}