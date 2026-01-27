package dev.majes.pgpcompanion.storage

import dev.majes.pgpcompanion.crypto.PgpKeyRingBundle

/**
 * Persists encrypted key material and metadata.
 * All data stored here must already be encrypted at rest.
 */
interface KeyStorage {

    /**
     * Saves an encrypted keyring bundle.
     */
    suspend fun saveKeyRingBundle(id: String, bundle: PgpKeyRingBundle)

    /**
     * Loads an encrypted keyring bundle by id.
     */
    suspend fun loadKeyRingBundle(id: String): PgpKeyRingBundle?

    /**
     * Deletes a stored keyring bundle.
     */
    suspend fun deleteKeyRingBundle(id: String)
}
