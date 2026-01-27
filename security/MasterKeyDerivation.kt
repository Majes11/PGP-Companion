package dev.majes.pgpcompanion.security

/**
 * Responsible for deriving a master key from a user password
 * using a KDF (e.g. PBKDF2).
 */
interface MasterKeyDerivation {

    /**
     * Derives a master key from the given password and salt.
     */
    fun deriveMasterKey(password: CharArray, salt: ByteArray): ByteArray

    /**
     * Generates a new random salt for key derivation.
     */
    fun generateSalt(): ByteArray
}
