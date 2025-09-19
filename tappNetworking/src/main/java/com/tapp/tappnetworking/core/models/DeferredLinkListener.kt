package com.tapp.tappnetworking.core.models


interface DeferredLinkListener {
    fun didReceiveDeferredLink(response: RequestModels.TappLinkDataResponse)
    fun didFailResolvingUrl(error: RequestModels.FailResolvingUrlResponse)
    // optional debug hook
    fun testListener(message: String);
}