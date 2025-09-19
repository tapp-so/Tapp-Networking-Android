package com.tapp.tappnetworking.core.models
import kotlinx.serialization.Serializable

@Serializable
enum class Environment {
    PRODUCTION,
    SANDBOX;

    fun environmentName(): String {
        return name
    }
}

object BaseURL {
    fun valueFor(env: Environment): String = when (env) {
        Environment.SANDBOX    -> "https://api.nkmhub.com/v1/ref"
        Environment.PRODUCTION -> "https://api.tapp.so/v1/ref"
    }
}