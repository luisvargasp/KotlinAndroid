package com.clean.kotlinjetpack

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceFactory {

   private const val BASE_URL = "https://b8cf2182-04d8-4b43-9449-a74eb9641d83.mock.pstmn.io/api/"

    //private const val BASE_URL = "http://misventas.azurewebsites.net/api/"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: ApiRestService = getRetrofit().create(ApiRestService::class.java)
}