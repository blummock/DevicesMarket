package com.example.core.data

data class BasketList(
    val basket: List<BasketItemEntity>
)

data class BasketItemEntity(
    val id: Int,
    val images: String,
    val price: Int,
    val title: String
)
