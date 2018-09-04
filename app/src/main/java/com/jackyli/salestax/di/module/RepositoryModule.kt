package com.jackyli.salestax.di.module

import com.jackyli.salestax.data.RestfulAPI
import com.jackyli.salestax.data.audit.AuditRepository
import com.jackyli.salestax.data.auth.repository.AuthRepository
import com.jackyli.salestax.data.products.repository.ProductsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
  @Provides
  @Singleton
  fun provideProductsRepository(restfulAPI: RestfulAPI): ProductsRepository = ProductsRepository(restfulAPI)

  @Provides
  @Singleton
  fun provideAuthRepository(restfulAPI: RestfulAPI): AuthRepository = AuthRepository(restfulAPI)

  @Provides
  @Singleton
  fun provideAuditRepository(restfulAPI: RestfulAPI): AuditRepository = AuditRepository(restfulAPI)
}