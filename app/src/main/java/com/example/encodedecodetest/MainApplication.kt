package com.example.encodedecodetest

import android.app.Application

class MainApplication : Application(), Dependencies.RepositoryProvider {

    private lateinit var repository: Repository

    override fun onCreate() {
        super.onCreate()

        makeDependencies()
    }

    private fun makeDependencies() {
        repository = DependencyFactory.createRepository(this)
    }

    override fun getRepository() = repository
}