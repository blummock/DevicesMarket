package com.example.core.use_cases

interface UseCases<T> {

    suspend fun fetch(): Result<T>
}