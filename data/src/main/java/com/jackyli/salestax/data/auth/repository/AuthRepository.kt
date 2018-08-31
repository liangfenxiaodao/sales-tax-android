package com.jackyli.salestax.data.auth.repository

import com.jackyli.salestax.data.RestfulAPI
import com.jackyli.salestax.data.auth.model.Auth
import com.jackyli.salestax.data.auth.model.LoginRequestBody
import com.jackyli.salestax.data.extensions.subscribeOnIO
import com.jackyli.salestax.data.store.AuthStore
import io.reactivex.Single
import javax.inject.Inject

class AuthRepository @Inject constructor(private val restfulApi: RestfulAPI) {
  fun login(username: String, password: String, grantType: String): Single<Auth> = restfulApi.login(username, password, grantType)
          .subscribeOnIO()
          .doOnSuccess { AuthStore.instance.token = it.token }
}