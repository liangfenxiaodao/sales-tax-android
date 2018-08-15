package com.jackyli.data.products.repository

import com.jackyli.data.RestfulAPI
import com.jackyli.data.products.model.Products
import com.jackyli.data.utils.extensions.subscribeOnIO
import io.reactivex.Single
import javax.inject.Inject

class ProductsRepository @Inject constructor(private val restfulApi: RestfulAPI) {
  fun getProducts(): Single<Products> = restfulApi.getProducts()
          .cache()
          .subscribeOnIO()
}