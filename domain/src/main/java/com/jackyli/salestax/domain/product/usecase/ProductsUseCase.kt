package com.jackyli.salestax.domain.product.usecase

import com.jackyli.salestax.data.products.repository.ProductsRepository
import com.jackyli.salestax.domain.product.model.Product
import com.jackyli.salestax.domain.util.changeToMainThread
import io.reactivex.Single
import javax.inject.Inject

class ProductsUseCase @Inject constructor(private val productsRepository: ProductsRepository) {
  fun getProductList(): Single<List<Product>> = productsRepository.getProducts()
          .map { it -> it.products?.map { Product(it) } ?: emptyList() }
          .changeToMainThread()
}