package com.tapp.tappnetworkingandroid

import com.tapp.tappnetworking.core.models.Environment
import com.tapp.tappnetworking.core.networking.ConfigProvider


object TestConfig : ConfigProvider {
    override val env: Environment = Environment.SANDBOX
    override val authToken: String? = "dummy-access-token" // leave empty if you don’t have one
    override val tappToken: String = "TT-123"
    override val bundleId: String? = "com.example.demo"
    override val androidId: String? = "ANDROID-123"
    override val deepLinkUrl: String? = null
    override val affiliateInt: Int = 1 // ADJUST=1, APPSFLYER=2, TAPP=3
}