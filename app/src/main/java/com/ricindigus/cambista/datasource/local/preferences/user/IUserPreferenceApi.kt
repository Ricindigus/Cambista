package com.ricindigus.cambista.datasource.local.preferences.user

interface IUserPreferenceApi {
    fun readUser(): String
    fun writeUser(user: String)
}