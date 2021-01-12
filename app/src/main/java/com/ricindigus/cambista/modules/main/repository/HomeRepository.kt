package com.ricindigus.cambista.modules.main.repository

import com.ricindigus.cambista.datasource.local.preferences.user.IUserPreferenceApi


class HomeRepository(private val userPreferenceApi: IUserPreferenceApi): IHomeRepository {
    override fun readUser() : String =
        userPreferenceApi.readUser()

    override fun writeUser(user: String) {
        userPreferenceApi.writeUser(user)
    }
}