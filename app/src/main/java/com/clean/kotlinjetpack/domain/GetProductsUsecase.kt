package com.clean.kotlinjetpack.domain

import com.clean.kotlinjetpack.Product
import com.clean.kotlinjetpack.data.ProductRepository

class GetProductsUsecase(val productRepository: ProductRepository) {


 suspend fun getProducts() :List<Product>{
   return   productRepository.getProducts()
 }
}