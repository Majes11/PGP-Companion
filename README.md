# PGP Companion  
Der systemweite Secure Layer für Android  
**Zero‑Trust · Open Source · OpenPGP‑kompatibel**

PGP Companion bringt starke, interoperable Verschlüsselung **in jede App auf Android** – ohne Server, ohne Accounts, ohne Datenabflüsse.  
Das Projekt ist vollständig Open Source (MIT‑Lizenz) und entwickelt, um sichere Kommunikation für alle zugänglich zu machen.

👉 **Website / GitHub Pages:** https://majes55.github.io/pgp-companion/  
👉 **Kontakt:** maikjeschke84@gmail.com  
👉 **GitHub:** https://github.com/majes55  

---

## 🚀 Was ist PGP Companion?

PGP Companion ist ein **systemweiter Secure Layer**, der OpenPGP‑Verschlüsselung überall nutzbar macht:

- in Messengern  
- in E‑Mails  
- in Notizen  
- im Browser  
- in jeder beliebigen App  

Das Ziel:  
**Starke Kryptografie für alle – ohne technische Hürden, ohne Plattform‑Lock‑In.**

---

## 🔐 Kernfunktionen

### **Secure Mode**
- Master‑Passwort  
- Android Keystore  
- Private Keys nur verschlüsselt gespeichert  
- Auto‑Lock + RAM‑Wipe  

### **OpenPGP‑Engine**
- RSA 4096  
- KeyRing‑Generator  
- ASCII‑Armor Export/Import  
- BouncyCastle‑basierte Encrypt/Decrypt‑Pipeline  

### **Systemweites Overlay (in Entwicklung)**
- Verschlüsseln/Entschlüsseln in jeder App  
- Kontextsensitiv  
- Zero‑Trust: keine Daten verlassen das Gerät  

### **Auto‑Detect Engine**
- erkennt PGP‑Blöcke automatisch  
- reduziert Fehler und manuelle Arbeit  

---

## 🧩 Architekturüberblick

- `security/` – Secure Mode, MasterKey, AES‑256‑GCM, Keystore  
- `crypto/` – OpenPGP‑KeyRing, Encryption Pipeline  
- `ui/` – Beispiel‑ViewModel, App‑Integration  
- Zero‑Trust: keine Server, keine Cloud, keine Telemetrie  

---

## 📦 Beispielcode (Kurz)

```kotlin
secureModeManager.setMasterPassword("Passwort!".toCharArray())
secureModeManager.unlock("Passwort!".toCharArray())

val key = PgpKeyManager.generateRsaKeyRing("Maik <mail@example.com>", "KeyPass!".toCharArray())
val encrypted = PgpKeyManager.encryptText("Hallo Welt", key.publicKeyRing)
val decrypted = PgpKeyManager.decryptText(encrypted, key.secretKeyRing, "KeyPass!".toCharArray())
