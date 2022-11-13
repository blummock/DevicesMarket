package com.example.core.repo

import com.example.core.data.BasketList

interface BasketRepository {
    suspend fun getBasketList(): BasketList
}