package com.clean.kotlinjetpack

class ProductRepositoryImpl :ProductRepository {
    override suspend fun getProducts(): List<Product> {

       return  ServiceFactory.apiService.getUsers()
    }
}