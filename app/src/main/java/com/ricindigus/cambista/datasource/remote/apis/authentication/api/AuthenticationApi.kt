package com.ricindigus.cambista.datasource.remote.apis.authentication.api

import com.ricindigus.cambista.datasource.remote.apis.authentication.dto.AuthenticationRequest
import com.ricindigus.cambista.datasource.remote.apis.authentication.dto.AuthenticationResponse
import com.ricindigus.cambista.datasource.remote.service.Result
import com.ricindigus.cambista.datasource.remote.service.safeApiCall
import kotlinx.coroutines.Dispatchers


class AuthenticationApi(private val IAuthenticationApiService: IAuthenticationApiService):
    IAuthenticationApi {
    override suspend fun attemptLogin(authenticationRequest: AuthenticationRequest): Result<AuthenticationResponse> {
        return safeApiCall(
            Dispatchers.IO
        ) { IAuthenticationApiService.authenticateUser(authenticationRequest) }
    }
}