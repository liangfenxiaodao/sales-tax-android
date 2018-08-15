package com.jackyli.salestax.main.di

import com.jackyli.domain.product.usecase.ProductsUseCase
import com.jackyli.salestax.di.scope.PerActivity
import com.jackyli.salestax.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class MainModule {
  @Provides
  @PerActivity
  fun provideMainPresenter(productsUseCase: ProductsUseCase): MainPresenter = MainPresenter(productsUseCase)
}