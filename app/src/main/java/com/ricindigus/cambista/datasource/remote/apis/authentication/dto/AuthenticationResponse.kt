package com.ricindigus.cambista.datasource.remote.apis.authentication.dto


import kotlinx.serialization.Serializable

@Serializable
data class AuthenticationResponse(
    val success: Boolean?,
    val message: String?
)

