package com.example.lab_week_11_a

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class PreferenceWrapper(private val sharedPreferences: SharedPreferences) {
    // text live data digunakan untuk memberitahu view model ketika teks berubah
    private val textLiveData = MutableLiveData<String>()

    init {
        // Register a listener ke shared preferences
        // Listener akan dipanggil ketika shared preference berubah

        sharedPreferences.registerOnSharedPreferenceChangeListener {
            _, key ->
            when(key) {
                KEY_TEXT -> {
                    // Notify view model ketika teks sudah berubah
                    // View model akan notify activity
                    textLiveData.postValue(
                        sharedPreferences.getString(KEY_TEXT, "")
                    )
                }
            }
        }
    }

    // Save text ke shared preferences
    fun saveText(text: String) {
        sharedPreferences.edit()
            .putString(KEY_TEXT, text)
            .apply()
    }

    // Get text dari shared preferences
    fun getText(): LiveData<String> {
        textLiveData.postValue(sharedPreferences.getString(KEY_TEXT, ""))
        return textLiveData
    }

    // Key yang digunakan untuk menyimpan teks di shared preferences
    companion object {
        const val KEY_TEXT = "keyText"
    }
}