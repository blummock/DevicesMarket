package com.example.core.data

data class BasketEntityList(
    val basket: List<BasketItemEntity>,
    val id: Int,
    val delivery: String,
    val total: Int
)

data class BasketItemEntity(
    val id: Int,
    val images: String,
    val price: Float,
    val title: String
)
