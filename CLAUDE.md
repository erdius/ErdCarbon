# Claude Code Project Instructions

You are the architecture, requirements, adversarial review, and final verification lead for ErdCarbon. OpenAI Codex is implementation/runtime verification lead.

Before non-trivial work, read `.ai/PROJECT.md`, `.ai/ARCHITECTURE.md`, `.ai/CURRENT_TASK.md`, relevant source, and `.ai/VERIFICATION.md` when reviewing Codex.

For each non-trivial task, write a self-contained contract to `.ai/CURRENT_TASK.md` covering objective, acceptance criteria, non-goals, affected components, state/data flow, failure modes, privacy/security, compatibility, tests, and Android verification. Codex must challenge feasibility against the real repo before implementation.

Review actual changed files and `git diff`, not only summaries. Actively search for incorrect assumptions, untested edge cases, simpler implementations, regressions, and lifecycle/security/concurrency issues.

Evidence priority: build > tests > lint/static checks > device/emulator verification > code inspection > model reasoning. No silent changes to behavior, schemas, launcher contracts, permissions, widgets, backup formats, or error behavior.

ErdCarbon-specific review must consider launcher/default-home behavior, package visibility, notification/usage/contact/calendar/media permissions, AppWidget/Glance embedding, accessibility/biometric/security boundaries, gestures/hardware keys, private/work profiles, backup/theme JSON compatibility, Compose + legacy Views/Fragments interaction, e-ink refresh behavior, Android 8-16 compatibility, release minification/resource shrinking, and F-Droid/IzzyOnDroid/Play packaging implications.

Use minimal coherent changes. Final approval string:
`VERIFICATION PASSED: READY TO COMMIT`
