package com.jackyli.salestax.di.component

import android.app.Application
import com.jackyli.domain.product.usecase.ProductsUseCase
import com.jackyli.salestax.di.module.ContextModule
import com.jackyli.salestax.di.module.IOModule
import com.jackyli.salestax.di.module.RepositoryModule
import com.jackyli.salestax.di.module.UsecaseModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ContextModule::class, IOModule::class, RepositoryModule::class, UsecaseModule::class])
interface ApplicationComponent {
  fun getProductsUsecase(): ProductsUseCase
  fun inject(application: Application)
}