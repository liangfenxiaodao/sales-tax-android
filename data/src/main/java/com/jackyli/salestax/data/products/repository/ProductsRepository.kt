package com.jackyli.salestax.data.products.repository

import com.jackyli.salestax.data.RestfulAPI
import com.jackyli.salestax.data.products.model.Products
import com.jackyli.salestax.data.extensions.subscribeOnIO
import io.reactivex.Single
import javax.inject.Inject

class ProductsRepository @Inject constructor(private val restfulApi: RestfulAPI) {
  fun getProducts(): Single<Products> = restfulApi.getProducts()
          .cache()
          .subscribeOnIO()
}