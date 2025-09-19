package com.tapp.tappnetworking.core.networking

import com.tapp.tappnetworking.core.models.BaseURL
import com.tapp.tappnetworking.core.models.Environment
import com.tapp.tappnetworking.core.models.HttpRequest
import com.tapp.tappnetworking.core.utils.JsonUtil

interface Endpoint {
    val method: HTTPMethod
    /** e.g. "influencer/add/deeplink" or "secrets" */
    val path: String
    /** optional headers/body (maps kept generic to avoid leaking specific libs) */
    val headers: Map<String, String>
    val body: Map<String, Any?>?

    /** Build final URL by combining base + "/" + path */
    fun url(env: Environment): String = "${BaseURL.valueFor(env)}/$path"

    /** Convert to transport-ready HttpRequest */
    fun toHttpRequest(env: Environment): HttpRequest {
        val jsonBody = body?.let { JsonUtil.encode(it) } // see helper below
        return HttpRequest(
            method = method.wire,
            url = url(env),
            headers = headers,
            body = jsonBody
        )
    }
}