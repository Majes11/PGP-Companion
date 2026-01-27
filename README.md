# PGP Companion  
A system‑wide secure layer for Android  
**Zero‑Trust · Open Source · OpenPGP‑Compatible**

PGP Companion brings strong, interoperable encryption to **any app on Android** — without servers, accounts, or data collection.  
The project is fully open source (MIT) and designed to make secure communication accessible to everyone.

👉 **Project Website:** https://majes55.github.io/pgp-companion/  
👉 **GitHub Profile:** https://github.com/majes55  
👉 **Contact:** maikjeschke84@gmail.com  

---

## 🚀 What is PGP Companion?

PGP Companion is a **system‑wide secure layer** that enables OpenPGP encryption anywhere on Android:

- messaging apps  
- email clients  
- note apps  
- browsers  
- any text field  

The goal is simple:  
**Make strong cryptography usable everywhere — without platform lock‑in or trust in third parties.**

---

## 🔐 Core Features

### **Secure Mode**
- Master password  
- Android Keystore integration  
- Private keys stored only in encrypted form  
- Auto‑lock and memory wiping  

### **OpenPGP Engine**
- RSA 4096 key generation  
- ASCII‑armor import/export  
- Encryption & decryption pipeline (BouncyCastle)  
- Fully compatible with GnuPG, Proton, Thunderbird, OpenKeychain  

### **System‑Wide Overlay (in development)**
- Encrypt/decrypt in any app  
- Lightweight, context‑aware UI  
- Zero‑Trust: no data leaves the device  

### **Auto‑Detect Engine**
- Automatically detects PGP blocks  
- Reduces user errors and manual steps  

---

## 🧩 Architecture Overview

- `security/` — Secure Mode, master key handling, AES‑256‑GCM, Keystore  
- `crypto/` — OpenPGP keyring generation and encryption pipeline  
- `ui/` — Example ViewModel and integration logic  
- Zero‑Trust design: no servers, no telemetry, no cloud  

---

## 📦 Example Usage

```kotlin
secureModeManager.setMasterPassword("Password!".toCharArray())
secureModeManager.unlock("Password!".toCharArray())

val key = PgpKeyManager.generateRsaKeyRing(
    "Maik <mail@example.com>",
    "KeyPass!".toCharArray()
)

val encrypted = PgpKeyManager.encryptText("Hello World", key.publicKeyRing)
val decrypted = PgpKeyManager.decryptText(
    encrypted,
    key.secretKeyRing,
    "KeyPass!".toCharArray()
)




