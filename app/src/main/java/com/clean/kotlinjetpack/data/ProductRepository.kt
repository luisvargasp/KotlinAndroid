package com.clean.kotlinjetpack.data

import com.clean.kotlinjetpack.Product

interface ProductRepository {
    suspend fun getProducts() :List<Product>
}