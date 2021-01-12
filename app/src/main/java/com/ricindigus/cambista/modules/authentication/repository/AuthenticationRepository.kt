package com.ricindigus.cambista.modules.authentication.repository

import com.ricindigus.cambista.datasource.remote.apis.authentication.api.IAuthenticationApi
import com.ricindigus.cambista.datasource.remote.apis.authentication.dto.AuthenticationResponse
import com.ricindigus.cambista.datasource.remote.service.Result
import com.ricindigus.cambista.domain.Authentication
import com.ricindigus.cambista.domain.asNetworkModel


class AuthenticationRepository(
    private val authenticationApi: IAuthenticationApi): IAuthenticationRepository {
    override suspend fun onInitSession(authentication: Authentication): Result<AuthenticationResponse> {
        return authenticationApi.attemptLogin(authentication.asNetworkModel())
    }


}