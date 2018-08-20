package com.jackyli.salestax.result

import com.jackyli.salestax.BasePresenter
import com.jackyli.salestax.domain.product.model.BaseTaxCalculator
import com.jackyli.salestax.domain.product.model.ImportedTaxCalculator
import com.jackyli.salestax.domain.product.model.Product
import com.jackyli.salestax.domain.product.usecase.ProductsUseCase
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class ResultPresenter @Inject constructor(private val productsUseCase: ProductsUseCase) : BasePresenter<ResultActivity>() {

  fun calculateResult(idList: Array<String>) {
    val disposable = productsUseCase.getProductList()
            .subscribeWith(object : DisposableSingleObserver<List<Product>>() {
              override fun onSuccess(products: List<Product>) {
                val taxCalculators = products.filter { idList.contains(it.id) }
                        .map { BaseTaxCalculator(it) }
                        .map { if (it.isImported()) ImportedTaxCalculator(it) else it }
                getView()?.displayResult(taxCalculators)
              }

              override fun onError(e: Throwable) {
                e.printStackTrace()
              }
            })
    disposables.add(disposable)
  }
}