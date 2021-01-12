package com.ricindigus.cambista.modules.authentication.repository

import com.ricindigus.cambista.datasource.remote.apis.authentication.dto.AuthenticationResponse
import com.ricindigus.cambista.datasource.remote.service.Result
import com.ricindigus.cambista.domain.Authentication


interface IAuthenticationRepository {
    suspend fun onInitSession(authentication: Authentication): Result<AuthenticationResponse>

}