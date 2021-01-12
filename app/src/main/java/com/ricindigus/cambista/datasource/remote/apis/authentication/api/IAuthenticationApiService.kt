package com.ricindigus.cambista.datasource.remote.apis.authentication.api

import com.ricindigus.cambista.datasource.remote.apis.authentication.dto.AuthenticationRequest
import com.ricindigus.cambista.datasource.remote.apis.authentication.dto.AuthenticationResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface IAuthenticationApiService {
    @POST("/login")
    suspend fun authenticateUser(@Body authenticationRequest: AuthenticationRequest): AuthenticationResponse
}