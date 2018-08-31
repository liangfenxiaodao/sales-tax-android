package com.jackyli.salestax.login.di

import com.jackyli.salestax.di.component.ApplicationComponent
import com.jackyli.salestax.di.scope.PerActivity
import com.jackyli.salestax.login.LoginActivity
import dagger.Component

@PerActivity
@Component(modules = [LoginModule::class], dependencies = [ApplicationComponent::class])
interface LoginComponent {
  fun inject(loginActivity: LoginActivity)
}