package com.ricindigus.cambista.datasource.remote.service

import com.bancom.cambix.datasource.remote.service.ErrorResponse
import com.squareup.moshi.Moshi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

/**
 * Represents the Success and Failure cases from the Remote API.
 */
sealed class Result<out T: Any>

data class Success<out T: Any>(val data: T) : Result<T>()

data class Failure(val code: Int? = null, val error: ErrorResponse? = null) : Result<Nothing>()


suspend fun <T: Any> safeApiCall(dispatcher: CoroutineDispatcher, apiCall: suspend () -> T): Result<T> {
    return withContext(dispatcher) {
        try {
            Success(apiCall.invoke())
        } catch (throwable: Throwable) {
            when (throwable) {
                is IOException -> Failure(
                    null,
                    null
                )
                is HttpException -> {
                    val code = throwable.code()
                    val errorResponse = convertErrorBody(throwable)
                    Failure(code, errorResponse)
                }
                else -> {
                    Failure(
                        null,
                        null
                    )
                }
            }
        }
    }
}

private fun convertErrorBody(throwable: HttpException): ErrorResponse? {
    return try {
        throwable.response()?.errorBody()?.source()?.let {
            val moshiAdapter = Moshi.Builder().build().adapter(ErrorResponse::class.java)
            moshiAdapter.fromJson(it)
        }
    } catch (exception: Exception) {
        null
    }
}



