package com.ricindigus.cambista.domain

import com.ricindigus.cambista.datasource.remote.apis.authentication.dto.AuthenticationRequest

data class Authentication(
    val user: String,
    val password: String)

fun Authentication.asNetworkModel() =
    AuthenticationRequest(user = user, password = password)
