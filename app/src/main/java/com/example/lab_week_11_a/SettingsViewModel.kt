package com.example.lab_week_11_a

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SettingsViewModel(private val settingsStore: SettingsStore) : ViewModel() {
    // Text live data untuk notify view model ketika teks berubah
    private val _textLiveData = MutableLiveData<String>()
    val textLiveData: LiveData<String> = _textLiveData

    init {
        // Launch coroutine untuk get text dari data store asynchronously
        viewModelScope.launch {
            settingsStore.text.collect {
                _textLiveData.value = it
            }
        }
    }

    fun saveText(text: String) {
        // Jalankan coroutine untuk save text ke dalam data store asynchronously
        viewModelScope.launch {
            settingsStore.saveText(text)
        }
    }
}