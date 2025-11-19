package com.example.lab_week_11_a

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class PreferenceViewModel(private val preferenceWrapper: PreferenceWrapper) : ViewModel() {
    // Save text ke shared preferences
    fun saveText(text: String) {
        preferenceWrapper.saveText(text)
    }

    // Get text dari shared preferences
    fun getText(): LiveData<String> {
        return preferenceWrapper.getText()
    }
}