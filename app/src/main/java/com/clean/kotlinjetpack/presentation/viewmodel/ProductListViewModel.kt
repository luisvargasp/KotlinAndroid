package com.clean.kotlinjetpack.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.clean.kotlinjetpack.domain.GetProductsUsecase
import com.clean.kotlinjetpack.data.ProductRepositoryImpl
import com.clean.kotlinjetpack.Resource
import kotlinx.coroutines.Dispatchers

class ProductListViewModel:ViewModel() {

    fun getProductsCall(){

    }


    fun getProducts() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = GetProductsUsecase(ProductRepositoryImpl()).getProducts()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}