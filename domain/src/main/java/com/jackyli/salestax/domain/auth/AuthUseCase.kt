package com.jackyli.salestax.domain.auth

import com.jackyli.salestax.data.auth.model.LoginRequestBody
import com.jackyli.salestax.data.auth.repository.AuthRepository
import com.jackyli.salestax.domain.util.changeToMainThread
import io.reactivex.Single
import javax.inject.Inject

class AuthUseCase @Inject constructor(private val authRepository: AuthRepository) {
  fun login(username: String, password: String): Single<String> = authRepository.login(username, password, "password")
          .map { it.token ?: "" }
          .changeToMainThread()
}