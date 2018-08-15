package com.jackyli.salestax.products

import com.jackyli.domain.product.model.Product
import com.jackyli.domain.product.usecase.ProductsUseCase
import com.jackyli.salestax.BasePresenter
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class ProductsPresenter @Inject constructor(private val productsUseCase: ProductsUseCase) : BasePresenter<ProductsActivity>() {
  fun loadProducts() {
    val disposable = productsUseCase.getProductList()
            .subscribeWith(object : DisposableSingleObserver<List<Product>>() {
              override fun onSuccess(products: List<Product>) {
                getView()?.setProducts(products)
              }

              override fun onError(e: Throwable) {
                e.printStackTrace()
              }
            })
    disposables.add(disposable)
  }
}