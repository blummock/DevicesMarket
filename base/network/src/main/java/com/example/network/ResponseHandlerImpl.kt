package com.example.network

import android.util.Log
import com.example.core.repo.ResponseHandler

object ResponseHandlerImpl : ResponseHandler {

    private fun <E> error(error: E) {
        Log.d("ResponseHandlerImpl", error.toString())
    }

    override suspend fun <T> handle(action: suspend () -> T): T? {
        return try {
            action.invoke()
        } catch (e: Exception) {
            error(e)
            null
        }
    }
}