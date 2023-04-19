package com.example.base_screen.use_cases

import com.example.core.data.BasketEntityList
import com.example.core.data.MarketEntityList
import com.example.core.exceptions.EmptyResponseException
import com.example.core.repo.MarketRepository
import com.example.core.use_cases.UseCases
import javax.inject.Inject

class MarketUseCases @Inject constructor(private val repository: MarketRepository) : UseCases<MarketEntityList> {

    override suspend fun fetch() = kotlin.runCatching { repository.getMarketList() ?: throw EmptyResponseException() }
        .onSuccess { Result.success(it) }
        .onFailure { Result.failure<BasketEntityList>(it) }
}