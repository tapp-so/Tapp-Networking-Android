package com.tapp.tappnetworking.core.networking

import com.tapp.tappnetworking.core.models.RequestModels

object Endpoints {

    /** influencer/add/deeplink */
    fun deeplink(config: ConfigProvider, deepLink: String): Endpoint = object : Endpoint {
        override val method = HTTPMethod.POST
        override val path = APIPath.deeplink.raw // already final, adjust if you ever prefix

        override val headers = mapOf(
            "Content-Type" to "application/json",
            "Authorization" to "Bearer ${config.authToken ?: ""}".trim()
        )

        override val body = mapOf(
            "tapp_token" to config.tappToken,
            "bundle_id" to (config.bundleId ?: ""),
            "android_id" to (config.androidId ?: ""),
            "deeplink" to deepLink
        )
    }

    /** secrets */
    fun secrets(config: ConfigProvider): Endpoint = object : Endpoint {
        override val method = HTTPMethod.POST
        override val path = APIPath.secrets.raw
        override val headers = mapOf(
            "Content-Type" to "application/json",
            "Authorization" to "Bearer ${config.authToken ?: ""}".trim()
        )
        override val body = mapOf(
            "tapp_token" to config.tappToken,
            "bundle_id" to (config.bundleId ?: ""),
            "mmp" to config.affiliateInt
        )
    }

    /** influencer/add */
    fun generateAffiliateUrl(config: ConfigProvider, req: RequestModels.GenerateAffiliateUrlRequest): Endpoint = object : Endpoint {
        override val method = HTTPMethod.POST
        override val path = "${APIPath.influencer.raw}/${APIPath.add.raw}"
        override val headers = mapOf(
            "Authorization" to "Bearer ${req.authToken}",
            "Content-Type" to "application/json"
        )
        override val body = mapOf(
            "tapp_token" to req.tappToken,
            "bundle_id" to (config.bundleId ?: ""),
            "mmp" to req.mmp,
            "adgroup" to (req.adGroup ?: ""),
            "creative" to (req.creative ?: ""),
            "influencer" to req.influencer,
            "data" to (req.data ?: emptyMap<String, Any?>())
        )
    }

    /** linkData */
    fun fetchLinkData(config: ConfigProvider, req: RequestModels.TappLinkDataRequest): Endpoint = object : Endpoint {
        override val method = HTTPMethod.POST
        override val path = APIPath.linkData.raw
        override val headers = mapOf(
            "Authorization" to "Bearer ${config.authToken ?: ""}".trim(),
            "Content-Type" to "application/json"
        )
        override val body = mapOf(
            "tapp_token" to config.tappToken,
            "bundle_id" to (config.bundleId ?: ""),
            "link_token" to req.linkToken
        )
    }

    /** event */
    fun tappEvent(
        config: ConfigProvider,
        event: RequestModels.TappEvent
    ): Endpoint = object : Endpoint {

        override val method = HTTPMethod.POST
        override val path = APIPath.event.raw

        override val headers = buildMap<String, String> {
            put("Content-Type", "application/json")
            config.authToken?.takeIf { it.isNotBlank() }?.let { put("Authorization", "Bearer $it") }
        }

        // Use your sealed class: RequestModels.EventAction
        private fun eventNameToString(action: RequestModels.EventAction): String =
            when (action) {
                is RequestModels.EventAction.custom -> action.customValue
                else -> action::class.simpleName ?: "unknown"
            }

        override val body = buildMap<String, Any?> {
            put("tapp_token", config.tappToken)
            put("bundle_id",  config.bundleId ?: "")
            put("event_name", eventNameToString(event.eventName))
            put("event_url",  config.deepLinkUrl ?: "")
        }
    }

}
