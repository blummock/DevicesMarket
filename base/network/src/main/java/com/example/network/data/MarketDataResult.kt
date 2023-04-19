package com.example.network.data

import com.google.gson.annotations.SerializedName

data class MarketDataResult(
    @SerializedName("home_store")
    val homeStore: List<HomeStoreData>,
    @SerializedName("best_seller")
    val bestSeller: List<BestSellerData>
)

data class HomeStoreData(
    val id: Int,
    @SerializedName("is_new")
    val isNew: Boolean?,
    val title: String,
    val subtitle: String,
    val picture: String,
    @SerializedName("is_buy")
    val isBy: Boolean
)

data class BestSellerData(
    val id: Int,
    @SerializedName("is_favorites")
    val isFavorites: Boolean,
    val title: String,
    @SerializedName("price_without_discount")
    val priceWithoutDiscount: Int,
    @SerializedName("discount_price")
    val discountPrice: Int,
    val picture: String
)


