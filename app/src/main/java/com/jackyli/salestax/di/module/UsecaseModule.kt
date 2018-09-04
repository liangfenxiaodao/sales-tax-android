package com.jackyli.salestax.di.module

import com.jackyli.salestax.data.audit.AuditRepository
import com.jackyli.salestax.data.auth.repository.AuthRepository
import com.jackyli.salestax.data.products.repository.ProductsRepository
import com.jackyli.salestax.domain.audit.usecase.AuditUseCase
import com.jackyli.salestax.domain.auth.AuthUseCase
import com.jackyli.salestax.domain.product.usecase.ProductsUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UsecaseModule {
  @Provides
  @Singleton
  fun provideProductsUseCase(productsRepository: ProductsRepository): ProductsUseCase = ProductsUseCase(productsRepository)

  @Provides
  @Singleton
  fun provideAuthUseCase(authRepository: AuthRepository): AuthUseCase = AuthUseCase(authRepository)

  @Provides
  @Singleton
  fun provideAuditUseCase(auditRepository: AuditRepository): AuditUseCase = AuditUseCase(auditRepository)
}