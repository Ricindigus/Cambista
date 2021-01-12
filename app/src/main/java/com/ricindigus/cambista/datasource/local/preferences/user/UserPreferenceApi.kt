package com.ricindigus.cambista.datasource.local.preferences.user

import android.content.SharedPreferences
import com.ricindigus.cambista.datasource.local.preferences.PreferenceKeys.PREFERENCE_USER_MAIL

class UserPreferenceApi(private val sharedPreferences: SharedPreferences) :
    IUserPreferenceApi {

    override fun readUser(): String {
        return sharedPreferences.getString(PREFERENCE_USER_MAIL,"")!!
    }

    override fun writeUser(user: String) {
        with (sharedPreferences.edit()) {
            putString(PREFERENCE_USER_MAIL,user)
            commit()
        }
    }
}