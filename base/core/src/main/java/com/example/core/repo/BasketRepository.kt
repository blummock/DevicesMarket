package com.example.core.repo

import com.example.core.data.BasketEntityList

interface BasketRepository {
    suspend fun getBasketList(): BasketEntityList?
}