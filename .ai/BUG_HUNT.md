# Dual-AI Bug Hunt Workflow

Use this procedure whenever the user asks to find bugs, audit the app, hunt regressions, or improve reliability.

## Claude: discovery lead
1. Read `CLAUDE.md`, `.ai/PROJECT.md`, `.ai/ARCHITECTURE.md`, `.ai/BUG_BACKLOG.md`, and relevant source/tests.
2. Inspect the real repository. Do not modify app code during discovery.
3. Prioritize crashes, wrong behavior, data loss, lifecycle/concurrency bugs, persistence/backup compatibility, permissions, memory/resource leaks, security/privacy, accessibility, performance, and Android/API compatibility.
4. For ErdCarbon also inspect launcher/default-home behavior, package visibility, notification/usage/contact/calendar/media permissions, special-access flows, private/work profile behavior, widget hosting/Glance, Compose + View/Fragment integration, gestures/hardware keys, e-ink refresh/display modes, backup/theme import compatibility, process recreation, API 26-36 behavior, and release-only R8/resource-shrinking regressions.
5. Record credible findings in `.ai/BUG_BACKLOG.md` with severity, confidence, file/component, evidence, reproduction steps, expected/current behavior, proposed regression test, and runtime verification needed.
6. Do not report style preferences as bugs.
7. Select exactly one highest-value bug that can be safely fixed in isolation and write its complete contract to `.ai/CURRENT_TASK.md`.
8. End discovery with `READY FOR CODEX FEASIBILITY AND REPRODUCTION`.

## Codex: reproduce, fix, verify
Read `AGENTS.md`, project/architecture/current-task files and this playbook; independently prove the diagnosis before editing. If wrong/incomplete, write `DESIGN REVISION REQUIRED` to `.ai/VERIFICATION.md`. If confirmed, identify root cause, make the smallest coherent fix, add a regression test when practical, run applicable Gradle build/tests/lint plus device/emulator checks, verify before/after behavior, inspect `git diff`, and record exact evidence in `.ai/VERIFICATION.md`. For release-sensitive changes also verify release/minified behavior when practical. End with `READY FOR CLAUDE ADVERSARIAL REVIEW`.

## Claude: adversarial review
Review actual diff/evidence/tests and confirm root cause was fixed rather than masked. Seek one remaining failure mode, one regression, one uncovered edge case, one simpler/safer implementation, and one missing test. For significant fixes construct at least three adversarial scenarios. If complete, end exactly with `VERIFICATION PASSED: READY TO COMMIT`.

## Loop discipline
Fix one bug at a time: discover/rank -> select one -> Codex reproduce/fix -> Claude review -> commit -> select next. Preserve unresolved findings in `.ai/BUG_BACKLOG.md`.