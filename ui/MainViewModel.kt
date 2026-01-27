package dev.majes.pgpcompanion.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.majes.pgpcompanion.crypto.PgpKeyManager
import dev.majes.pgpcompanion.crypto.PgpKeyRingBundle
import dev.majes.pgpcompanion.overlay.OverlayController
import dev.majes.pgpcompanion.overlay.OverlayState
import dev.majes.pgpcompanion.security.SecureModeManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * High‑level ViewModel that coordinates:
 * - secure mode
 * - key management
 * - overlay behavior
 */
class MainViewModel(
    private val secureModeManager: SecureModeManager,
    private val pgpKeyManager: PgpKeyManager,
    private val overlayController: OverlayController
) : ViewModel() {

    data class UiState(
        val secureModeUnlocked: Boolean = false,
        val activeKeyBundle: PgpKeyRingBundle? = null,
        val overlayState: OverlayState = OverlayState.Hidden,
        val errorMessage: String? = null
    )

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState

    fun unlockSecureMode(password: CharArray) {
        viewModelScope.launch {
            val success = secureModeManager.unlock(password)
            _uiState.value = _uiState.value.copy(
                secureModeUnlocked = success,
                errorMessage = if (!success) "Failed to unlock secure mode" else null
            )
            // TODO: wipe password from memory
        }
    }

    fun lockSecureMode() {
        secureModeManager.lock()
        _uiState.value = _uiState.value.copy(
            secureModeUnlocked = false,
            activeKeyBundle = null
        )
    }

    fun onTextContextChanged(text: String) {
        viewModelScope.launch {
            val current = _uiState.value
            val overlay = overlayController.handleTextContext(
                text = text,
                activeKeyBundle = current.activeKeyBundle
            )
            _uiState.value = current.copy(overlayState = overlay)
        }
    }

    fun setActiveKeyBundle(bundle: PgpKeyRingBundle) {
        _uiState.value = _uiState.value.copy(activeKeyBundle = bundle)
    }
}
