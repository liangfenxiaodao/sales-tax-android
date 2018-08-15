package com.jackyli.salestax.products.di

import com.jackyli.domain.product.usecase.ProductsUseCase
import com.jackyli.salestax.di.scope.PerActivity
import com.jackyli.salestax.products.ProductsPresenter
import dagger.Module
import dagger.Provides

@Module
class ProductsModule {
  @Provides
  @PerActivity
  fun provideMainPresenter(productsUseCase: ProductsUseCase): ProductsPresenter = ProductsPresenter(productsUseCase)
}