package com.jackyli.salestax.products

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.jackyli.salestax.domain.product.model.Product
import com.jackyli.salestax.BaseActivity
import com.jackyli.salestax.MainApplication
import com.jackyli.salestax.R
import com.jackyli.salestax.products.di.DaggerProductsComponent
import com.jackyli.salestax.products.di.ProductsModule
import com.jackyli.salestax.result.ResultActivity
import com.jackyli.salestax.utils.launchActivity
import kotlinx.android.synthetic.main.activity_products.*
import kotlinx.android.synthetic.main.item_product.*
import javax.inject.Inject

class ProductsActivity : BaseActivity<ProductsPresenter>() {
  @Inject
  lateinit var productsPresenter: ProductsPresenter

  @Inject
  lateinit var productsAdapter: ProductsAdapter

  fun setProducts(products: List<Product>) {
    productsAdapter.products = products
    productsAdapter.notifyDataSetChanged()
  }

  fun updateCheckoutButtonStatus() {
    checkout_button.isEnabled = productsAdapter.getSelectedProducts().count() > 0
  }

  private fun checkout() {
    getPresenter().checkout(productsAdapter.getSelectedProducts())
  }

  override fun initialiseView() {
    with(item_product) {
      product_name.text = getString(R.string.product_name)
      product_price.text = getString(R.string.product_price)
      product_imported.text = getString(R.string.product_imported)
      product_checkbox.visibility = View.GONE
    }
    with(products_recycler_view) {
      setHasFixedSize(true)
      layoutManager = LinearLayoutManager(context)
      adapter = productsAdapter
      setItemViewCacheSize(10)
    }
    with(checkout_button) {
      isEnabled = false
      setOnClickListener { checkout() }
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

  override fun getPresenter(): ProductsPresenter {
    return productsPresenter
  }

  fun showReceipt(idList: List<String>) {
    launchActivity<ResultActivity> {
      putExtra("idList", idList.toTypedArray())
    }
  }
}
