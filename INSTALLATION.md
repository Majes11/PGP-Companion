---

INSTALLATION.md

`markdown

Installation Guide – PGP Companion

This document explains how to set up the development environment, build the project, and run PGP Companion on an Android device or emulator.

PGP Companion is a Kotlin‑based Android application using Jetpack Compose, Gradle, and BouncyCastle for OpenPGP operations.

---

Requirements

Before you begin, ensure you have the following:

- Android Studio (Hedgehog or newer)
- JDK 17 (bundled with Android Studio)
- Android SDK 34 or higher
- Git
- A physical Android device or emulator (Android 8.0+ recommended)

---

Clone the Repository

Use Git to clone the project:

`
git clone https://github.com/majes55/pgp-companion.git (github.com in Bing)
cd pgp-companion
`

---

Open the Project in Android Studio

1. Start Android Studio  
2. Select Open an existing project  
3. Choose the pgp-companion folder  
4. Wait for Gradle to sync (first sync may take a minute)

Android Studio will automatically detect:

- Kotlin configuration  
- Compose setup  
- Gradle modules  

---

Build the Project

To build the app:

- Click Build → Make Project  
- Or run:

`
./gradlew assembleDebug
`

The output APK will be located in:

`
app/build/outputs/apk/debug/
`

---

Run on a Device

Option A: Physical Device

1. Enable Developer Options  
2. Enable USB Debugging  
3. Connect the device via USB  
4. In Android Studio, select your device  
5. Click Run ▶

Option B: Emulator

1. Open Device Manager  
2. Create a new virtual device (Pixel recommended)  
3. Choose Android 13 or 14 system image  
4. Start the emulator  
5. Click Run ▶

---

Project Structure

The project is organized into modular folders:

`
security/      – Secure mode, master key, keystore integration
crypto/        – OpenPGP engine and keyring logic
storage/       – Encrypted key storage
detect/        – PGP block detection
overlay/       – System‑wide overlay controller
ui/            – ViewModel and UI state
`

See FOLDER-STRUCTURE.md for details.

---

Dependencies

Key libraries used:

- Jetpack Compose (UI)
- Kotlin Coroutines
- BouncyCastle (OpenPGP)
- AndroidX libraries

Dependencies are defined in:

`
app/build.gradle
`

---

Troubleshooting

Gradle sync fails  
- Ensure you are using the latest Android Studio  
- Check that JDK 17 is selected  
- Verify internet connection for dependency download  

App does not run on device  
- Ensure device has Android 8.0+  
- Enable USB debugging  
- Accept the RSA fingerprint prompt on the device  

Compose preview not working  
- Update Android Studio to the latest version  
- Ensure Kotlin and Compose versions match the Gradle config  

---

Next Steps for Developers

- Review ARCHITECTURE.md  
- Review SECURITY-ARCHITECTURE.md  
- Explore the skeleton classes in security/, crypto/, and overlay/  
- Begin implementing core logic inside the provided structure  

---

Contact

For development questions:

Maik – Project Lead & Developer  
maikjeschke84@gmail.com
`


---
