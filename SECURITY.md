# Security Policy

PGP Companion is a security‑critical project.  
We take responsible disclosure, cryptographic integrity, and Zero‑Trust principles very seriously.

---

## 🔒 Supported Versions

Security fixes are applied to the `main` branch.  
Pre‑release versions may also receive patches when necessary.

---

## 🛡️ Reporting a Vulnerability

If you discover a security vulnerability:

### Please DO NOT:
- open a public Issue  
- submit a public Pull Request  
- disclose the vulnerability on social media or forums  

### Instead, please report it privately to:

📧 **maikjeschke84@gmail.com**

---

## 🧩 What to Include

To help us investigate efficiently, please include:

- Description of the vulnerability  
- Steps to reproduce  
- Expected vs. actual behavior  
- Potential impact  
- Proof‑of‑Concept (if available)  
- Suggested fix (optional)  

We appreciate detailed reports.

---

## 🕒 Response Timeline

We aim to follow this timeline:

- **24–72 hours:** Initial response  
- **7–14 days:** Investigation and reproduction  
- **14–30 days:** Fix or mitigation  
- **Before public disclosure:** Coordinated release with the reporter  

---

## 🔐 Security Principles

PGP Companion follows strict security guidelines:

- **Zero‑Trust:** No servers, no accounts, no telemetry  
- **Local‑Only:** Private keys never leave the device  
- **Encrypted‑At‑Rest:** AES‑256‑GCM for all sensitive data  
- **Keystore Integration:** Master key protected by Android Keystore  
- **Memory Wipe:** Sensitive data cleared from RAM when possible  
- **Open Source:** Transparent, auditable, community‑reviewed  

---

## 🧪 Cryptographic Changes

Any change to cryptographic components must:

- be documented  
- be justified  
- undergo review  
- not weaken security  

---

## 🤝 Thank You

Security is a shared responsibility.  
Thank you to everyone who helps keep PGP Companion safe.
