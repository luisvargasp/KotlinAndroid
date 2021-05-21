package com.clean.kotlinjetpack

class GetProductsUsecase(val productRepository: ProductRepository) {


 suspend fun getProducts() :List<Product>{
   return   productRepository.getProducts()
 }
}