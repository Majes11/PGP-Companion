package dev.majes.pgpcompanion.overlay

import dev.majes.pgpcompanion.detect.AutoDetectEngine
import dev.majes.pgpcompanion.crypto.PgpKeyManager
import dev.majes.pgpcompanion.crypto.PgpKeyRingBundle

/**
 * Controls the system‑wide overlay behavior:
 * - showing/hiding overlay
 * - reacting to detected PGP content
 * - triggering encrypt/decrypt actions
 */
class OverlayController(
    private val autoDetectEngine: AutoDetectEngine,
    private val pgpKeyManager: PgpKeyManager
) {

    /**
     * Called when text is available from clipboard or focused field.
     */
    suspend fun handleTextContext(
        text: String,
        activeKeyBundle: PgpKeyRingBundle?
    ): OverlayState {
        // TODO:
        // 1. detect PGP blocks
        // 2. decide whether to show encrypt/decrypt actions
        // 3. return state for UI
        return OverlayState.Hidden
    }

    /**
     * Encrypts the given text using the active key bundle.
     */
    suspend fun encrypt(text: String, keyBundle: PgpKeyRingBundle): String {
        // TODO: delegate to PgpKeyManager
        return text
    }

    /**
     * Decrypts the given text using the active key bundle.
     */
    suspend fun decrypt(text: String, keyBundle: PgpKeyRingBundle, passphrase: CharArray): String {
        // TODO: delegate to PgpKeyManager
        return text
    }
}

/**
 * Represents the current overlay UI state.
 */
sealed class OverlayState {
    object Hidden : OverlayState()
    data class ShowEncrypt(val plainText: String) : OverlayState()
    data class ShowDecrypt(val encryptedText: String) : OverlayState()
}
