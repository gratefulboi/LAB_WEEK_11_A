package com.example.lab_week_11_a

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Get preference wrapper dari aplikasi
        val preferenceWrapper = (application as SettingsApplication).settingsStore

        // Create view model instance dengan preference wrapper sebagai parameter
        // Untuk pass preference wrapper ke view model, perlu view model factory
        val preferenceViewModel = ViewModelProvider(this, object :  ViewModelProvider.Factory {
            override fun <T: ViewModel> create(modelClass: Class<T>): T {
                return SettingsViewModel(preferenceWrapper) as T
            }
        })[SettingsViewModel::class.java]

        // Observe teks live data
        preferenceViewModel.textLiveData.observe(this) {
            // Update text view ketika text live data berubah
            findViewById<TextView>(R.id.activity_main_text_view).text = it
        }

        findViewById<Button>(R.id.activity_main_button).setOnClickListener {
            // Save text ketika button di click
            preferenceViewModel.saveText(
                findViewById<EditText>(R.id.activity_main_edit_text).text.toString()
            )
        }

    }
}