# Tapp-Networking-Android

Lightweight, transport-agnostic networking foundation for the Tapp SDKs. It builds environment-aware URLs and typed endpoints (`deeplink`, `secrets`, `influencer/add`, `linkData`, `event`) and returns plain Kotlin request shapes—so downstream SDKs can choose any HTTP client (OkHttp, Ktor, Retrofit).

---

## Features
- **Env-aware base URLs** (Sandbox / Production)
- **Typed endpoint builders** → consistent headers/body
- **Pure models** (`RequestModels`) — no UI deps
- **ConfigProvider SPI** — plug in your tokens/config
- **HTTP-client agnostic** — returns a simple `HttpRequest`
- **JitPack-ready** (release variant + sources)

## Compatibility
- **minSdk** 21
- **compileSdk** 34
- **AGP** 8.7.x • **Kotlin** 1.9.x • **JDK** 17 (bytecode 11/17 both fine)

---

## Installation (via JitPack)

1) Add JitPack to your **settings.gradle(.kts)**:
```kotlin
dependencyResolutionManagement {
  repositories {
    google()
    mavenCentral()
    maven("https://jitpack.io")
  }
}
