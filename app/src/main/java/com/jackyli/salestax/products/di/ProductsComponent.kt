package com.jackyli.salestax.products.di

import com.jackyli.salestax.di.component.ApplicationComponent
import com.jackyli.salestax.di.scope.PerActivity
import com.jackyli.salestax.products.ProductsActivity
import dagger.Component

@PerActivity
@Component(modules = [ProductsModule::class], dependencies = [ApplicationComponent::class])
interface ProductsComponent {
  fun inject(productsActivity: ProductsActivity)
}