package com.jackyli.salestax.result.di

import com.jackyli.salestax.di.scope.PerActivity
import com.jackyli.salestax.domain.product.usecase.ProductsUseCase
import com.jackyli.salestax.result.ResultPresenter
import dagger.Module
import dagger.Provides

@Module
class ResultModule {
  @Provides
  @PerActivity
  fun provideResultsPresenter(productsUseCase: ProductsUseCase): ResultPresenter = ResultPresenter(productsUseCase)
}