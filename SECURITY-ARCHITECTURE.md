

`markdown

Security Architecture – PGP Companion

PGP Companion is designed as a fully local, zero‑trust encryption layer for Android.  
This document describes the security model, cryptographic foundations, threat boundaries, and data‑flow protections that ensure confidentiality, integrity, and user control.

---

Security Philosophy

- Zero‑Trust: No servers, no accounts, no telemetry  
- Local‑Only: All cryptographic operations occur on the device  
- User‑Controlled: No automatic key uploads, sync, or cloud storage  
- Minimal Attack Surface: No background services, no network dependencies  
- Transparent: Open source, auditable, reproducible  
- Fail‑Secure: If something goes wrong, the system locks rather than weakens security  

---

Core Security Components

Secure Mode Manager  
Controls locked/unlocked state, master password, and in‑memory key lifecycle.

Master Key Derivation  
Uses PBKDF2 with a strong salt to derive a deterministic master key from the user password.

Android Keystore Wrapper  
Wraps the derived master key using hardware‑backed encryption where available.

Encrypted Key Storage  
Stores only encrypted key material; never stores raw private keys.

OpenPGP Engine  
Handles RSA‑4096 key generation, encryption, decryption, and ASCII‑armor import/export.

Auto‑Detect Engine  
Identifies PGP blocks without logging or storing user content.

Overlay Controller  
Provides system‑wide encryption/decryption actions without persisting data.

---

Cryptographic Foundations

Key Generation  
- RSA‑4096  
- BouncyCastle OpenPGP implementation  
- Strong random number generation (SecureRandom)

Key Protection  
- Secret keys encrypted with AES‑256‑GCM  
- Master key derived via PBKDF2 (high iteration count)  
- Master key wrapped using Android Keystore  
- Optional hardware‑backed StrongBox support  

Data Encryption  
- OpenPGP message format  
- Hybrid encryption (RSA + AES session key)  
- ASCII‑armored output for interoperability  

Memory Handling  
- Sensitive byte arrays wiped after use  
- CharArray used for passwords  
- No long‑lived plaintext in memory  

---

Secure Mode Lifecycle

Locked State  
- No decrypted key material in memory  
- Key storage inaccessible  
- Overlay limited to detection only  

Unlocking  
1. User enters master password  
2. PBKDF2 derives master key  
3. Keystore unwraps encrypted key material  
4. Decrypted key material loaded into memory  
5. Secure mode becomes active  

Auto‑Lock  
Triggered by:  
- App backgrounding  
- Timeout  
- Explicit user action  

All sensitive data is wiped immediately.

---

Data Flow Protection

Key Storage Flow

`
secret key → AES‑256‑GCM → encrypted key bundle → persistent storage
`

Unlock Flow

`
password → PBKDF2 → master key → Keystore unwrap → decrypted key material
`

Encryption Flow

`
plaintext → OpenPGP encrypt → ciphertext → overlay/UI
`

Decryption Flow

`
ciphertext → OpenPGP decrypt → plaintext → overlay/UI
`

No intermediate data is logged or persisted.

---

Attack Surface Analysis

Network Attack Surface  
- None (no servers, no sync, no telemetry)

Local Attack Surface  
- Clipboard (mitigated by short‑lived access)  
- Overlay (no data stored, no logs)  
- UI (never receives raw key material)

Storage Attack Surface  
- Only encrypted key bundles stored  
- Master key never stored  
- Keystore‑wrapped key material cannot be exported  

Memory Attack Surface  
- Sensitive data wiped after use  
- No long‑lived plaintext buffers  
- No caching of decrypted content  

---

Threat Model

Protected Against

- Device theft (keys encrypted at rest)  
- Malware without root (Keystore isolation)  
- Clipboard sniffing (no persistent clipboard use)  
- App‑level attacks (no raw key exposure)  
- Network interception (no network usage)  
- Key exfiltration (Keystore prevents export)  

Not Protected Against

- Rooted devices with full memory access  
- Hardware keyloggers  
- Compromised OS  
- Side‑channel attacks on compromised hardware  

---

Logging and Telemetry

- No analytics  
- No crash reporting  
- No network logs  
- No storage of user content  
- No key metadata uploaded  

All logs are disabled or sanitized.

---

Future Hardening

- StrongBox‑only mode  
- Secure UI surfaces (anti‑screenshot)  
- Encrypted in‑memory containers  
- Optional hardware‑bound key pairs  
- Tamper detection  

---

Contact

For security questions or responsible disclosure:

Maik – Project Lead & Developer  
maikjeschke84@gmail.com
`
