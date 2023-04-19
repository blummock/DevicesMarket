package com.example.core.data

data class MarketEntityList(
    val homeStore: List<HomeStoreEntity>,
    val bestSeller: List<BestSellerEntity>
)

data class HomeStoreEntity(
    val id: Int,
    val isNew: Boolean?,
    val title: String,
    val subtitle: String,
    val picture: String,
    val isBy: Boolean
)

data class BestSellerEntity(
    val id: Int,
    val isFavorites: Boolean,
    val title: String,
    val priceWithoutDiscount: Int,
    val discountPrice: Int,
    val picture: String
)


