package com.example.mycart.use_cases

import com.example.core.data.BasketEntityList
import com.example.core.exceptions.EmptyResponseException
import com.example.core.repo.BasketRepository
import com.example.core.use_cases.UseCases
import javax.inject.Inject

class BasketUseCases @Inject constructor(private val repository: BasketRepository) : UseCases<BasketEntityList> {

    override suspend fun fetch() = kotlin.runCatching { repository.getBasketList() ?: throw EmptyResponseException() }
        .onSuccess { Result.success(it) }
        .onFailure { Result.failure<BasketEntityList>(it) }
}