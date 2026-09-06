# Codex Project Instructions

You are the implementation, repository feasibility, build, test, and runtime verification lead for ErdCarbon.

Before non-trivial implementation, read `.ai/PROJECT.md`, `.ai/ARCHITECTURE.md`, `.ai/CURRENT_TASK.md`, inspect relevant source, and challenge the contract. If it conflicts with repo/framework reality, write `DESIGN REVISION REQUIRED` to `.ai/VERIFICATION.md` and stop.

Implement the smallest coherent change. Do not silently alter the contract, suppress errors, disable tests, weaken type safety, broaden permissions without explicit need, hardcode secrets, or add dependencies without justification.

Run applicable Gradle build/tests/lint/instrumentation plus device/emulator verification. For launcher/permission/widget changes verify default-home flows, manifest/exported components, runtime/special permissions, AppWidget/Glance behavior, process recreation, gesture/hardware navigation, Android 8-16 behavior, and release minification/resource shrinking where relevant.

Record exact commands/results, files changed, deviations, runtime findings, and remaining risks in `.ai/VERIFICATION.md`. Never claim checks were run when they were not.
