package com.jackyli.salestax.products

import androidx.recyclerview.widget.LinearLayoutManager
import com.jackyli.salestax.domain.product.model.Product
import com.jackyli.salestax.BaseActivity
import com.jackyli.salestax.MainApplication
import com.jackyli.salestax.R
import com.jackyli.salestax.products.di.DaggerProductsComponent
import com.jackyli.salestax.products.di.ProductsModule
import kotlinx.android.synthetic.main.activity_products.*
import javax.inject.Inject

class ProductsActivity : BaseActivity<ProductsPresenter>() {
  @Inject
  lateinit var productsPresenter: ProductsPresenter

  @Inject
  lateinit var productsAdapter: ProductsAdapter

  override fun getPresenter(): ProductsPresenter {
    return productsPresenter
  }

  override fun initialiseView() {
    with(products_recycler_view) {
      setHasFixedSize(true)
      layoutManager = LinearLayoutManager(context)
      adapter = productsAdapter
      setItemViewCacheSize(10)
    }
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
    return R.layout.activity_products
  }

  fun setProducts(products: List<Product>) {
    productsAdapter.products = products
    productsAdapter.notifyDataSetChanged()
  }
}
