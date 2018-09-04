package com.jackyli.salestax.di.component

import android.app.Application
import android.content.Context
import com.jackyli.salestax.data.RestfulAPI
import com.jackyli.salestax.di.module.ContextModule
import com.jackyli.salestax.di.module.IOModule
import com.jackyli.salestax.di.module.RepositoryModule
import com.jackyli.salestax.di.module.UsecaseModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ContextModule::class, IOModule::class, RepositoryModule::class, UsecaseModule::class])
interface ApplicationComponent {
  fun getRestfulAPI(): RestfulAPI
  fun getContext(): Context
  fun inject(application: Application)
}