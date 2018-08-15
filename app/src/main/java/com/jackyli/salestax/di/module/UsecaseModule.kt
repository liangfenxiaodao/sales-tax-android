package com.jackyli.salestax.di.module

import com.jackyli.salestax.data.products.repository.ProductsRepository
import com.jackyli.salestax.domain.product.usecase.ProductsUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UsecaseModule {
  @Provides
  @Singleton
  fun provideProductsUseCase(productsRepository: ProductsRepository): ProductsUseCase = ProductsUseCase(productsRepository)
}