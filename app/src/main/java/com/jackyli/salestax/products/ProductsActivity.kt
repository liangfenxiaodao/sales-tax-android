package com.jackyli.salestax.products

import com.jackyli.domain.product.model.Product
import com.jackyli.salestax.BaseActivity
import com.jackyli.salestax.MainApplication
import com.jackyli.salestax.R
import com.jackyli.salestax.products.di.DaggerProductsComponent
import com.jackyli.salestax.products.di.ProductsModule
import javax.inject.Inject

class ProductsActivity : BaseActivity<ProductsPresenter>() {
  @Inject
  lateinit var productsPresenter: ProductsPresenter

  override fun getPresenter(): ProductsPresenter {
    return productsPresenter
  }

  override fun initialiseView() {
    productsPresenter.loadProducts()
  }

  override fun initialiseInjector() {
    DaggerProductsComponent.builder()
            .applicationComponent((application as MainApplication).applicationComponent)
            .productsModule(ProductsModule())
            .build()
            .inject(this)
  }

  override fun getLayout(): Int {
    return R.layout.activity_main
  }

  fun setProducts(products: List<Product>) {
    println("setProducts")
    products.forEach { println(it.name) }
  }
}
