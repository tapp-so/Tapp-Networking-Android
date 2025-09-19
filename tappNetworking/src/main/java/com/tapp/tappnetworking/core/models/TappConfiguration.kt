package com.tapp.tappnetworking.core.models
import kotlinx.serialization.Serializable

@Serializable
data class TappConfiguration(
    val authToken: String,
    val env: Environment,
    val tappToken: String,
    val affiliate: Affiliate
)