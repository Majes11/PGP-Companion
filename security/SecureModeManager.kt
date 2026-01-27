package dev.majes.pgpcompanion.security

import kotlinx.coroutines.flow.StateFlow

/**
 * Manages the secure mode lifecycle:
 * - master password
 * - unlocking / locking
 * - key derivation
 * - keystore wrapping
 */
class SecureModeManager(
    private val keyDerivation: MasterKeyDerivation,
    private val keystoreWrapper: KeystoreWrapper,
) {

    enum class SecureModeState {
        LOCKED,
        UNLOCKED,
        INITIAL_SETUP
    }

    val state: StateFlow<SecureModeState>
        get() = TODO("Expose secure mode state as StateFlow")

    /**
     * Sets or changes the master password.
     * This should:
     * - derive a new master key
     * - wrap it with Android Keystore
     * - persist wrapped key
     */
    suspend fun setMasterPassword(password: CharArray) {
        // TODO: implement master password setup
        // 1. derive master key
        // 2. wrap with keystore
        // 3. persist wrapped key
        // 4. wipe password from memory
    }

    /**
     * Unlocks secure mode using the master password.
     * Should:
     * - derive master key
     * - unwrap stored key material
     * - make decrypted key available in memory (temporarily)
     */
    suspend fun unlock(password: CharArray): Boolean {
        // TODO: implement unlock flow
        // return true if successful, false otherwise
        return false
    }

    /**
     * Locks secure mode and wipes sensitive material from memory.
     */
    fun lock() {
        // TODO: clear in‑memory keys and update state
    }

    /**
     * Returns whether secure mode is currently unlocked.
     */
    fun isUnlocked(): Boolean {
        // TODO: return current state
        return false
    }
}
