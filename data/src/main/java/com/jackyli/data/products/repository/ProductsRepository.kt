package com.jackyli.data.products.repository

import com.jackyli.data.API
import com.jackyli.data.products.model.Product
import io.reactivex.Single
import javax.inject.Inject

class ProductsRepository @Inject constructor(private val api: API) {
  fun getProducts(): Single<List<Product>> = api.getProducts().map { it.products }
}