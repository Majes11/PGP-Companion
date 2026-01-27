package dev.majes.pgpcompanion.crypto

/**
 * High‑level API for working with OpenPGP keyrings and text encryption.
 * Internally this will use BouncyCastle or another OpenPGP implementation.
 */
interface PgpKeyManager {

    /**
     * Generates a new RSA keyring (e.g. 4096‑bit) for the given user ID.
     */
    suspend fun generateRsaKeyRing(
        userId: String,
        passphrase: CharArray
    ): PgpKeyRingBundle

    /**
     * Imports an existing keyring from ASCII‑armored data.
     */
    suspend fun importKeyRing(
        armoredPublicKey: String,
        armoredSecretKey: String?,
        passphrase: CharArray?
    ): PgpKeyRingBundle

    /**
     * Exports the public keyring as ASCII‑armored text.
     */
    suspend fun exportPublicKey(bundle: PgpKeyRingBundle): String

    /**
     * Exports the secret keyring as ASCII‑armored text.
     */
    suspend fun exportSecretKey(bundle: PgpKeyRingBundle): String

    /**
     * Encrypts plain text for the given public keyring.
     */
    suspend fun encryptText(
        plainText: String,
        recipientPublicKey: PgpKeyRingBundle
    ): String

    /**
     * Decrypts PGP‑encrypted text using the given secret keyring.
     */
    suspend fun decryptText(
        encryptedText: String,
        keyBundle: PgpKeyRingBundle,
        passphrase: CharArray
    ): String
}
