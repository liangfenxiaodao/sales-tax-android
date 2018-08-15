package com.jackyli.data.products.repository

import com.jackyli.data.API
import com.jackyli.data.products.model.Products
import com.jackyli.data.utils.extensions.subscribeOnIO
import io.reactivex.Single
import javax.inject.Inject

class ProductsRepository @Inject constructor(private val api: API) {
  fun getProducts(): Single<Products> = api.getProducts()
          .cache()
          .subscribeOnIO()
}