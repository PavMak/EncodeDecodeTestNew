package com.example.encodedecodetest

import android.content.Context

object DependencyFactory {

    fun createRepository(context: Context): DefaultRepository{
        val preferencesModule = PreferencesModule(context)

        return DefaultRepository(preferencesModule)
    }
}