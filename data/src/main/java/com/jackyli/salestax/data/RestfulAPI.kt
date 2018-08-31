package com.jackyli.salestax.data

import com.jackyli.salestax.data.auth.model.Audits
import com.jackyli.salestax.data.auth.model.Auth
import com.jackyli.salestax.data.products.model.Products
import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface RestfulAPI {
  @GET("bins/lyg4c")
  fun getProducts(): Single<Products>

  @FormUrlEncoded
  @POST("/auth")
  fun login(@Field("username") username: String, @Field("password") password: String, @Field("grant_type") grantType: String): Single<Auth>

  @GET("/audits/search?owner=me")
  fun getAudits(): Single<Audits>
}
