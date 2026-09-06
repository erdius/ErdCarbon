# ErdCarbon Architecture Guidance

Preserve existing repository patterns unless a task explicitly requires architectural change.

## Boundaries to protect
- Launcher/default-home flows must always leave the user a recoverable path; avoid changes that can strand the device in a broken home state.
- Permission requests must be least-privilege, feature-scoped, version-aware, and resilient to denial/revocation.
- Compose and legacy View/Fragment boundaries must remain lifecycle-safe and avoid duplicate state ownership.
- AppWidget/Glance embedding must handle unavailable/removed widgets and host lifecycle changes.
- Backup/theme JSON changes require backward-compatibility and malformed-input handling.
- Profile/package/app-discovery logic must account for API-level and visibility differences.
- No-network/privacy posture should be preserved unless an explicit product decision changes it.

## Android/mobile checks
For relevant changes verify API 26-36 behavior, process recreation, launcher/default-app transitions, manifest/exported components, special permissions, notifications, usage access, contacts/calendar/media access, private/work profiles, gesture/hardware-key navigation, widget hosting, accessibility/biometric boundaries, e-ink refresh, and recovery from invalid settings/imports.

## Release checks
Because release builds use minification and resource shrinking, verify release assembly for reflection/resource-sensitive changes. Review Fastlane/store metadata implications where applicable.

## Change discipline
Prefer small diffs and existing abstractions. Permission, backup, launcher, and externally observable contracts require explicit compatibility/regression analysis.
