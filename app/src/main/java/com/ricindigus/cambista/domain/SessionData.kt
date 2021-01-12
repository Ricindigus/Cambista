package com.ricindigus.cambista.domain

import com.ricindigus.cambista.datasource.remote.apis.authentication.dto.AuthenticationResponse

data class SessionData(
    val success: Boolean,
    val message: String
)

fun AuthenticationResponse.asDomainModel() =
    SessionData(
        success = success?:false,
        message = message?:""
    )