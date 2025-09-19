package com.tapp.tappnetworking.core.networking

import com.tapp.tappnetworking.core.models.Environment

/**
 * Minimal config interface the networking layer needs.
 * Implement this in your Core/Adjust SDKs to adapt existing storage (keystore, prefs, etc.).
 */
interface ConfigProvider {
    val env: Environment
    val authToken: String?      // "Bearer ..." will be added by Endpoints where needed
    val tappToken: String
    val bundleId: String?
    val androidId: String?
    val affiliateInt: Int       // ADJUST=1, APPSFLYER=2, TAPP=3 etc.
    val deepLinkUrl: String?    // optional
}