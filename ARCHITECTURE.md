
Architecture Overview – PGP Companion

PGP Companion is a modular, zero‑trust encryption layer for Android.  
The architecture separates cryptographic logic, secure storage, UI state, and system‑wide integration to ensure security, maintainability, and auditability.

---

Core Principles

- Zero‑Trust: No servers, no accounts, no telemetry  
- Local‑Only: All cryptographic operations happen on the device  
- Encrypted‑At‑Rest: AES‑256‑GCM for all sensitive data  
- Keystore‑Backed: Master key material wrapped using Android Keystore  
- Modular: Each component isolated and testable  
- Audit‑Friendly: Clear boundaries and minimal attack surface  
- Composable UI: UI logic separated from cryptographic logic  

---

Module Structure

`
security/      – Secure mode, master key, keystore integration
crypto/        – OpenPGP keyring generation and encryption pipeline
storage/       – Encrypted key storage
detect/        – Auto‑detection of PGP blocks
overlay/       – System‑wide overlay controller
ui/            – ViewModel and UI state management
`

---

security

Handles all sensitive key material and secure mode lifecycle.

SecureModeManager

- Manages locked/unlocked state  
- Derives master key (PBKDF2)  
- Wraps/unwraps key material via Android Keystore  
- Wipes sensitive data from memory  
- Exposes secure mode state via StateFlow  

MasterKeyDerivation

- Derives master key from password  
- Generates salts  
- Produces deterministic key material for unlocking  

KeystoreWrapper

- Wraps/unwraps master key material  
- Ensures hardware‑backed protection  
- Prevents raw key export  

Data Flow

`
password → PBKDF2 → master key → KeystoreWrapper.wrap() → encrypted master key
`

---

crypto

Contains all OpenPGP‑related logic.

PgpKeyManager

- RSA‑4096 key generation  
- Import/export of ASCII‑armored keyrings  
- Encryption/decryption of text  
- Passphrase‑protected secret key handling  

PgpKeyRingBundle

Container for:

- public key data  
- secret key data  
- fingerprint  
- metadata (user ID, creation date)  

Data Flow

`
plaintext → encrypt(public key) → PGP message
PGP message → decrypt(secret key + passphrase) → plaintext
`

---

storage

Stores encrypted key material.

KeyStorage

- Saves encrypted key bundles  
- Loads key bundles  
- Deletes key bundles  
- Never stores unencrypted data  

Data Flow

`
PgpKeyRingBundle (encrypted) → persistent storage
`

---

detect

Identifies PGP blocks in arbitrary text.

AutoDetectEngine

- Pattern‑based detection of:
  - public key blocks  
  - private key blocks  
  - PGP messages  
  - signatures  
- Returns metadata (start, end, type)

Example:

`
-----BEGIN PGP MESSAGE-----
`

→ classified as MESSAGE

---

overlay

Controls the system‑wide overlay for encrypt/decrypt actions.

OverlayController

- Receives text from clipboard or focused field  
- Uses AutoDetectEngine to classify content  
- Determines whether to show:
  - Encrypt action  
  - Decrypt action  
- Delegates cryptographic operations to PgpKeyManager  
- Produces an OverlayState for UI rendering  

Overlay States

- Hidden  
- ShowEncrypt(plainText)  
- ShowDecrypt(encryptedText)  

---

ui

High‑level ViewModel coordinating secure mode, key management, and overlay logic.

MainViewModel

- Exposes UI state via StateFlow  
- Handles unlocking/locking  
- Manages active key bundle  
- Updates overlay state  
- Coordinates crypto + secure mode + detection  

UI State Includes

- secure mode unlocked  
- active key bundle  
- overlay state  
- error messages  

---

End‑to‑End Flows

Encryption Flow

`
User types text → Overlay detects plaintext → ShowEncrypt
User taps Encrypt → PgpKeyManager.encryptText() → encrypted block shown
`

Decryption Flow

`
User copies PGP block → AutoDetectEngine detects message → ShowDecrypt
User taps Decrypt → PgpKeyManager.decryptText() → plaintext returned
`

Secure Mode Flow

`
User enters password → SecureModeManager.unlock()
→ derive master key → unwrap keystore key → decrypt key storage
`

---

Security Boundaries

- Cryptographic operations never leave crypto/  
- Master key never leaves memory unencrypted  
- Keystore‑wrapped keys cannot be exported  
- UI never receives raw key material  
- Overlay never stores data persistently  
- Detection engine never logs content  

---

Future Extensions

- File encryption  
- Secure Notes  
- Hardware‑backed StrongBox keys  
- Multi‑key support  
- Enterprise policy engine  
- Plugin system for advanced workflows  

---

Contact

Maik – Project Lead & Developer  
maikjeschke84@gmail.com
`

