package com.clean.kotlinjetpack.data

import com.clean.kotlinjetpack.Product

class ProductRepositoryImpl : ProductRepository {
    override suspend fun getProducts(): List<Product> {

       return  ServiceFactory.apiService.getUsers()
    }
}