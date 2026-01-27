package dev.majes.pgpcompanion.security

/**
 * Wraps and unwraps key material using Android Keystore.
 */
interface KeystoreWrapper {

    /**
     * Wraps (encrypts) the given key material using a keystore‑backed key.
     */
    fun wrapKey(rawKey: ByteArray): ByteArray

    /**
     * Unwraps (decrypts) previously wrapped key material.
     */
    fun unwrapKey(wrappedKey: ByteArray): ByteArray
}
