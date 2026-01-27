# PGP Companion – Roadmap

This document outlines the planned development milestones for PGP Companion.  
The roadmap is structured into quarterly goals and focuses on delivering a secure, transparent, and user‑friendly OpenPGP layer for Android.

---

## 🎯 Vision

PGP Companion aims to provide a **system‑wide, zero‑trust encryption layer** for Android that works across all apps without servers, accounts, or data collection.  
The roadmap reflects this mission by prioritizing security, usability, and interoperability.

---

# 🗓️ 2025 Roadmap

## **Q1 – Core Security Foundation**
Focus: Building the cryptographic and secure‑storage backbone.

- Secure Mode (master password + Android Keystore)
- Encrypted private key storage (AES‑256‑GCM)
- Key derivation (PBKDF2) and master key wrapping
- OpenPGP key generation (RSA 4096)
- Import/export of public and private keyrings
- Basic encryption/decryption pipeline (BouncyCastle)
- Initial project documentation (README, LICENSE, CONTRIBUTING, SECURITY)

**Deliverable:** A functional cryptographic core with secure key handling.

---

## **Q2 – System Integration & Overlay MVP**
Focus: Making encryption usable across the entire system.

- System‑wide overlay MVP (lightweight UI)
- Auto‑Detect engine for PGP blocks
- Clipboard integration (secure handling)
- Basic UI/UX for key management
- Error handling and user feedback flows
- GitHub Pages website + branding
- First internal test builds

**Deliverable:** A minimal but usable app capable of encrypting/decrypting text in any app.

---

## **Q3 – Security Hardening & Audit Preparation**
Focus: Strengthening the security model and preparing for external review.

- Threat model (STRIDE or LINDDUN)
- Memory wiping improvements
- Side‑channel considerations
- Keystore fallback strategies
- Secure logging (or no‑logging policy)
- Code cleanup and refactoring
- Expanded documentation (architecture, security model)
- Community testing and feedback

**Deliverable:** A hardened, audit‑ready codebase.

---

## **Q4 – Public Release & Pro Features**
Focus: Releasing the app and preparing optional commercial extensions.

- Play Store release (free, open‑source core)
- UI polish and accessibility improvements
- Pro/Enterprise feature planning (closed‑source modules)
- File encryption support (optional)
- Secure Notes (optional)
- Team/Enterprise key management concepts
- Funding applications (NLnet, NGI Zero, OTF)

**Deliverable:** Public release + foundation for sustainable development.

---

# 🧭 Long‑Term Goals (Beyond 2025)

- Full accessibility support (screen readers, large text)
- Multi‑device key synchronization (local‑only, optional)
- Hardware‑backed key storage (StrongBox)
- Integration with external OpenPGP tools
- Plugin system for advanced workflows
- Enterprise‑grade policy controls
- Optional paid version (Open Core model)

---

# 🤝 Community Involvement

Contributions are welcome at all stages:

- Code contributions  
- Security reviews  
- UI/UX suggestions  
- Documentation improvements  
- Feature proposals  

See `CONTRIBUTING.md` for details.

---

# 📬 Contact

**Maik – Project Lead & Developer**  
📧 maikjeschke84@gmail.com  
GitHub: https://github.com/majes55

---

# 📄 License

PGP Companion is released under the **MIT License**.  
See the `LICENSE` file for details.
