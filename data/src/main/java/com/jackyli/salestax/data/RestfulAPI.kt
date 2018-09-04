package com.jackyli.salestax.data

import com.jackyli.salestax.data.audit.Audit
import com.jackyli.salestax.data.auth.model.Audits
import com.jackyli.salestax.data.auth.model.Auth
import com.jackyli.salestax.data.products.model.Products
import io.reactivex.Single
import retrofit2.http.*

interface RestfulAPI {
  @GET("bins/lyg4c")
  fun getProducts(): Single<Products>

  @FormUrlEncoded
  @POST("/auth")
  fun login(@Field("username") username: String, @Field("password") password: String, @Field("grant_type") grantType: String): Single<Auth>

  @GET("/audits/search?owner=me")
  fun getAudits(): Single<Audits>

  @GET("/audits/{id}")
  fun getAudit(@Path("id") auditId: String): Single<Audit>
}
