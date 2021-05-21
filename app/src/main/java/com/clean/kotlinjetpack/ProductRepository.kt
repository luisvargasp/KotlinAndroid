package com.clean.kotlinjetpack

interface ProductRepository {
    suspend fun getProducts() :List<Product>
}