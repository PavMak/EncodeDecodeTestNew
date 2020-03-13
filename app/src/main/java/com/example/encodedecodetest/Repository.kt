package com.example.encodedecodetest

interface Repository {

    fun getPublicKey(): String

    fun getPrivateKey(): String

    fun setPublicKey(publicKey: String)

    fun setPrivateKey(privateKey: String)
}