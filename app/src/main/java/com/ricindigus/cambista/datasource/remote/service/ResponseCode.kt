package com.ricindigus.cambista.datasource.remote.service

object ResponseCode {
    //Network: Code State 2xx
    const val OK = 200
    //Network: Code State 4xx
    const val UNAUTHORIZED = 401
    const val FORBIDDEN = 403
    const val NOT_FOUND = 404
    //Network: Code State 5xx
    const val INTERNAL_SERVER_ERROR = 500
}