package com.jackyli.salestax.login.di

import com.jackyli.salestax.di.scope.PerActivity
import com.jackyli.salestax.domain.auth.AuthUseCase
import com.jackyli.salestax.login.LoginPresenter
import dagger.Module
import dagger.Provides

@Module
class LoginModule {
  @Provides
  @PerActivity
  fun providesLoginPresenter(authUseCase: AuthUseCase): LoginPresenter = LoginPresenter(authUseCase)
}