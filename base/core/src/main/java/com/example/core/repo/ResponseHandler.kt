package com.example.core.repo

interface ResponseHandler {

    suspend fun <T> handle(action: suspend () -> T): T?
}