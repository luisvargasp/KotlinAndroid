package com.clean.kotlinjetpack

import retrofit2.http.GET

interface ApiRestService {

    @GET("products")
    suspend fun getUsers(): List<Product>
}