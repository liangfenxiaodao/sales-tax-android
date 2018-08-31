package com.jackyli.salestax.data

import com.jackyli.salestax.data.store.AuthStore
import okhttp3.Interceptor
import okhttp3.Response

class AuthenticationInterceptor : Interceptor {
  override fun intercept(chain: Interceptor.Chain?): Response {
    if (chain == null) {
      return Response.Builder().code(404).build()
    }

    var request = chain.request()
    if (AuthStore.instance.token != null) {
      request = request.newBuilder()
              .addHeader("Authorization", "Bearer ${AuthStore.instance.token}")
              .build()
    }
    return chain.proceed(request)
  }
}