package com.ricindigus.cambista.modules.main.repository

interface IHomeRepository {
    fun readUser() : String
    fun writeUser(user: String)
}