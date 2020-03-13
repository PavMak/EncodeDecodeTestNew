package com.example.encodedecodetest

class DefaultRepository(
        private val preferencesModule: PreferencesModule
): Repository {

    override fun getPublicKey() = preferencesModule.publicKey

    override fun getPrivateKey() = preferencesModule.privateKey

    override fun setPublicKey(publicKey: String) {
        if(preferencesModule.publicKey.isEmpty()) {
            preferencesModule.publicKey = publicKey
        }
    }

    override fun setPrivateKey(privateKey: String) {
        if(preferencesModule.privateKey.isEmpty()) {
            preferencesModule.privateKey = privateKey
        }
    }
}