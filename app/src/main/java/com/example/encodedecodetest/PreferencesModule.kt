package com.example.encodedecodetest

import android.content.Context
import androidx.preference.PreferenceManager

class PreferencesModule(context: Context) {

    private val preferences = PreferenceManager.getDefaultSharedPreferences(context)

    var publicKey: String
        get() = preferences.getString(PreferencesKeys.PUBLIC_KEY.name, "")!!
        set(value) {
            preferences.edit().putString(PreferencesKeys.PUBLIC_KEY.name, value).apply()
        }

    var privateKey: String
        get() = preferences.getString(PreferencesKeys.PRIVATE_KEY.name, "")!!
        set(value) {
            preferences.edit().putString(PreferencesKeys.PRIVATE_KEY.name, value).apply()
        }
}