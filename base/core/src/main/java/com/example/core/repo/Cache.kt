package com.example.core.repo

interface Cache<T> {

    suspend fun getOrUpdate(supplier: suspend () -> T): T
}