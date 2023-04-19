package com.example.network.data

data class BasketDataResult(
    val basket: List<BasketItemData>,
    val id: Int,
    val delivery: String,
    val total: Int
)

data class BasketItemData(
    val id: Int,
    val images: String,
    val price: Float,
    val title: String
)
