package com.example.encodedecodetest

import android.app.Application
import android.content.Context
import com.example.encodedecodetest.Dependencies.Companion.repository
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException

data class Dependencies(
        val repository: Repository
) {
    interface RepositoryProvider {
        fun getRepository(): Repository
    }

    companion object {

        fun repository(context: Context): Repository {
            val application = context.applicationContext as Application
            if (application is RepositoryProvider) {
                return (application as RepositoryProvider).getRepository()
            } else {
                throw IllegalStateException("Application class should implement RepositoryProvider interface")
            }
        }
    }
}

fun Context.dependencies() = Dependencies(
        repository(this)
)