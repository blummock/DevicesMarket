package com.example.network.adapters

import com.example.core.data.*
import com.example.network.data.BasketDataResult
import com.example.network.data.MarketDataResult
import com.example.network.data.ProductInfoResult

fun MarketDataResult.toEntity() = MarketEntityList(
    homeStore = this.homeStore.map {
        HomeStoreEntity(
            id = it.id,
            isNew = it.isNew,
            title = it.title,
            subtitle = it.subtitle,
            picture = it.picture,
            isBy = it.isBy
        )
    },
    bestSeller = this.bestSeller.map {
        BestSellerEntity(
            id = it.id,
            isFavorites = it.isFavorites,
            title = it.title,
            priceWithoutDiscount = it.priceWithoutDiscount,
            discountPrice = it.discountPrice,
            picture = it.picture
        )
    }
)

fun BasketDataResult.toEntity() = BasketEntityList(
    basket = this.basket.map {
        BasketItemEntity(
            id = it.id,
            images = it.images,
            price = it.price,
            title = it.title
        )
    },
    id = id,
    delivery = delivery,
    total = total
)

fun ProductInfoResult.toEntity() = ProductEntity(
    id = id,
    cpu = cpu,
    camera = camera,
    capacity = capacity,
    color = color,
    images = images,
    isFavorites = isFavorites,
    price = price,
    rating = rating,
    sd = sd,
    ssd = ssd,
    title = title
)