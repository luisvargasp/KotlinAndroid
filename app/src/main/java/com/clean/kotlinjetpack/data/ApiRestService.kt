package com.clean.kotlinjetpack.data

import com.clean.kotlinjetpack.Product
import retrofit2.http.GET

interface ApiRestService {

    @GET("products")
    suspend fun getUsers(): List<Product>
}