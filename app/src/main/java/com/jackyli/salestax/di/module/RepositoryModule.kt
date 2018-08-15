package com.jackyli.salestax.di.module

import com.jackyli.data.RestfulAPI
import com.jackyli.data.products.repository.ProductsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
  @Provides
  @Singleton
  fun provideProductsRepository(restfulAPI: RestfulAPI): ProductsRepository = ProductsRepository(restfulAPI)
}