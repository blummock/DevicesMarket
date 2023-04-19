package com.example.core.data

data class ProductEntity(
    val id: String,
    val cpu: String,
    val camera: String,
    val capacity: List<String>,
    val color: List<String>,
    val images: List<String>,
    val isFavorites: Boolean,
    val price: Float,
    val rating: Float,
    val sd: String,
    val ssd: String,
    val title: String
)
