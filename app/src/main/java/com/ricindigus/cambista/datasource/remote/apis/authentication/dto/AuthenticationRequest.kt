package com.ricindigus.cambista.datasource.remote.apis.authentication.dto

import kotlinx.serialization.Serializable

@Serializable
data class AuthenticationRequest(
    val user: String,
    val password: String)