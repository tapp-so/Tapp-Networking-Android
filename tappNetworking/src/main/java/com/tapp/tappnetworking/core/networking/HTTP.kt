package com.tapp.tappnetworking.core.networking

enum class HTTPMethod(val wire: String) {
    OPTIONS("OPTIONS"), GET("GET"), HEAD("HEAD"), POST("POST"),
    PUT("PUT"), PATCH("PATCH"), DELETE("DELETE"), TRACE("TRACE"), CONNECT("CONNECT")
}

enum class APIPath(val raw: String) {
    id("id"),
    influencer("influencer"),
    add("add"),
    deeplink("deeplink"),
    secrets("secrets"),
    event("event"),
    linkData("linkData");

    val prefixInfluencer: String get() = raw.prefix("influencer")
    val prefixAdd: String get() = raw.prefix("add")
}

// String helpers like on iOS
private fun String.prefix(value: String): String = "$value/$this"