# ErdCarbon Project

## Platform
Android text-based/e-ink-friendly launcher for minimal/dumbphone devices including Mudita Kompakt.

## Current stack
- Kotlin 2.1.x / Jetpack Compose + Material 3
- Some legacy Views/Fragments + ViewBinding
- minSdk 26, target/compile SDK 36
- Java/JVM 17
- WorkManager, Navigation, Glance AppWidget, Biometric, Glide, Gson
- Gradle Kotlin DSL
- Fastlane/release metadata; release minification and resource shrinking enabled

## Product constraints
- Launcher/home-screen behavior is system-critical and must remain recoverable.
- Broad/special permissions are feature-driven; never expand them casually.
- No INTERNET permission/data collection is an important privacy property.
- E-ink refresh, hardware-key navigation, widgets, profiles, notifications, and backup/theme compatibility are core concerns.
- Support Android 8 through Android 16 behavior where applicable.

## Standard verification
- `./gradlew :app:assembleDebug`
- applicable Android instrumentation/Compose tests
- lint results reviewed even though current Gradle config does not abort on lint errors
- release build/minification checks for release-sensitive changes
- device/emulator launcher/default-home checks for launcher behavior

## Release/signing
Release signing may use local `keystore.properties` or CI environment variables. Never commit signing material or secrets.
