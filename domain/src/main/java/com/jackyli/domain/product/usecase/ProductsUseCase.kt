package com.jackyli.domain.product.usecase

import com.jackyli.data.products.repository.ProductsRepository
import com.jackyli.domain.product.model.Product
import com.jackyli.domain.util.changeToMainThread
import io.reactivex.Single
import javax.inject.Inject

class ProductsUseCase @Inject constructor(private val productsRepository: ProductsRepository) {
  fun getProductList(): Single<List<Product>> = productsRepository.getProducts()
          .map { it -> it.products?.map { Product(it) } ?: emptyList() }
          .changeToMainThread()
}