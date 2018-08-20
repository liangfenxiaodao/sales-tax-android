package com.jackyli.salestax.data

import com.jackyli.salestax.data.products.model.Products
import io.reactivex.Single
import retrofit2.http.GET

interface RestfulAPI {
  @GET("bins/lyg4c")
  fun getProducts(): Single<Products>
}
