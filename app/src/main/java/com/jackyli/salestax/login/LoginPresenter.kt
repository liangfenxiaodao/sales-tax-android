package com.jackyli.salestax.login

import com.jackyli.salestax.BasePresenter
import com.jackyli.salestax.domain.auth.AuthUseCase
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class LoginPresenter @Inject constructor(private val authUseCase: AuthUseCase) : BasePresenter<LoginActivity>() {
  fun login(username: String, password: String) {
    val disposable = authUseCase.login(username, password).subscribeWith(object : DisposableSingleObserver<String>() {
      override fun onSuccess(token: String) {
        println("onSuccess")
        println(token)
      }

      override fun onError(e: Throwable) {
        e.printStackTrace()
      }
    })
  }
}