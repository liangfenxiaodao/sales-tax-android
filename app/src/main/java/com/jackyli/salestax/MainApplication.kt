package com.jackyli.salestax

import android.app.Application
import com.jackyli.salestax.di.component.ApplicationComponent
import com.jackyli.salestax.di.component.DaggerApplicationComponent
import com.jackyli.salestax.di.module.ContextModule
import com.jackyli.salestax.di.module.IOModule
import com.jackyli.salestax.di.module.RepositoryModule
import com.jackyli.salestax.di.module.UsecaseModule

class MainApplication : Application() {
  lateinit var applicationComponent: ApplicationComponent

  override fun onCreate() {
    super.onCreate()
    initialiseInjector()
  }

  private fun initialiseInjector() {
    applicationComponent = DaggerApplicationComponent.builder()
            .contextModule(ContextModule(this))
            .iOModule(IOModule(this))
            .repositoryModule(RepositoryModule())
            .usecaseModule(UsecaseModule())
            .build()
    applicationComponent.inject(this)
  }
}