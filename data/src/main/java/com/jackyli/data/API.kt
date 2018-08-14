package com.jackyli.data

import com.jackyli.data.products.model.Products
import io.reactivex.Single
import retrofit2.http.GET

interface API {
  @GET("bins/q2w98")
  fun getProducts(): Single<Products>
}
