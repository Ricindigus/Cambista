package com.ricindigus.cambista.datasource.remote.apis.authentication.api

import com.ricindigus.cambista.datasource.remote.apis.authentication.dto.AuthenticationRequest
import com.ricindigus.cambista.datasource.remote.apis.authentication.dto.AuthenticationResponse
import com.ricindigus.cambista.datasource.remote.service.Result


interface IAuthenticationApi {
   suspend fun attemptLogin(authenticationRequest: AuthenticationRequest): Result<AuthenticationResponse>
}