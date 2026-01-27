
This document describes the folder layout of the PGP Companion project.  
The structure is designed for clarity, modularity, and security, following a zero‑trust architecture.

---

Overview

`
app/
 └── src/
      └── main/
           ├── java/dev/majes/pgpcompanion/
           │    ├── security/
           │    ├── crypto/
           │    ├── storage/
           │    ├── detect/
           │    ├── overlay/
           │    └── ui/
           └── res/
`

Each module is isolated to reduce attack surface and improve maintainability.

---

security

Contains all components responsible for secure mode, master key handling, and keystore integration.

Files include:

- SecureModeManager.kt  
- MasterKeyDerivation.kt  
- KeystoreWrapper.kt  

Purpose:

- Derive master key  
- Wrap/unwrap key material  
- Manage locked/unlocked state  
- Wipe sensitive data  

---

crypto

Contains the OpenPGP engine and keyring logic.

Files include:

- PgpKeyManager.kt  
- PgpKeyRingBundle.kt  

Purpose:

- RSA‑4096 key generation  
- Encryption and decryption  
- Import/export of ASCII‑armored keyrings  
- Passphrase‑protected secret key handling  

---

storage

Handles encrypted persistence of key material.

Files include:

- KeyStorage.kt  

Purpose:

- Save encrypted key bundles  
- Load encrypted key bundles  
- Delete key bundles  
- Never store raw private keys  

---

detect

Contains the PGP auto‑detection engine.

Files include:

- AutoDetectEngine.kt  

Purpose:

- Detect PGP blocks in arbitrary text  
- Classify block types  
- Provide metadata for overlay logic  

---

overlay

Controls the system‑wide overlay for encryption and decryption actions.

Files include:

- OverlayController.kt  
- OverlayState.kt  

Purpose:

- React to detected PGP content  
- Trigger encrypt/decrypt actions  
- Provide UI state for overlay rendering  

---

ui

Contains the high‑level ViewModel and UI state management.

Files include:

- MainViewModel.kt  

Purpose:

- Coordinate secure mode, crypto, and overlay  
- Expose UI state via StateFlow  
- Manage active key bundle  
- Handle user actions  

---

Additional Files

- README.md  
- SECURITY.md  
- ARCHITECTURE.md  
- ROADMAP.md  
- CONTRIBUTING.md  
- LICENSE  

These documents provide project overview, security model, roadmap, contribution guidelines, and licensing.

---

Build System

Gradle files:

- settings.gradle  
- build.gradle  
- app/build.gradle  

Purpose:

- Define modules  
- Configure Kotlin and Compose  
- Manage dependencies (BouncyCastle, Coroutines, etc.)  

---

Summary

The folder structure is intentionally modular:

- security handles secrets  
- crypto handles OpenPGP  
- storage handles encrypted persistence  
- detect handles PGP recognition  
- overlay handles system‑wide UI  
- ui handles app‑level state  

This separation supports auditing, testing, and future expansion.

`

---
