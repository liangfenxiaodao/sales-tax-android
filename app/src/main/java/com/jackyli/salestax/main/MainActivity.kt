package com.jackyli.salestax.main

import com.jackyli.domain.product.model.Product
import com.jackyli.salestax.BaseActivity
import com.jackyli.salestax.MainApplication
import com.jackyli.salestax.R
import com.jackyli.salestax.main.di.DaggerMainComponent
import com.jackyli.salestax.main.di.MainModule
import javax.inject.Inject

class MainActivity : BaseActivity<MainPresenter>() {
  @Inject
  lateinit var mainPresenter: MainPresenter

  override fun getPresenter(): MainPresenter {
    return mainPresenter
  }

  override fun initialiseView() {
    mainPresenter.loadProducts()
  }

  override fun initialiseInjector() {
    DaggerMainComponent.builder()
            .applicationComponent((application as MainApplication).applicationComponent)
            .mainModule(MainModule())
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
