package dev.majes.pgpcompanion.crypto

/**
 * Represents a pair of public and secret keyrings plus metadata.
 * This is a logical container, not necessarily the raw OpenPGP types.
 */
data class PgpKeyRingBundle(
    val id: String,
    val userId: String,
    val fingerprint: String,
    val createdAt: Long,
    val publicKeyData: ByteArray,
    val secretKeyData: ByteArray
    // TODO: add more metadata if needed
)
