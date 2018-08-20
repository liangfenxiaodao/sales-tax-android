package com.jackyli.salestax.products

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jackyli.salestax.R
import com.jackyli.salestax.domain.product.model.Product
import kotlinx.android.synthetic.main.item_product.view.*

class ProductsAdapter : RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {
  var products: List<Product>? = null

  fun getSelectedProducts()  = products?.filter { it.isChecked } ?: emptyList()

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
    return ViewHolder(view)
  }

  override fun getItemCount(): Int = products?.count() ?: 0

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val product = products?.get(position) ?: return
    holder.view.apply {
      product_name.text = product.getName()
      product_price.text = product.getPrice().toString()
      product_imported.text = product.isImported().toString()
      product_checkbox.setOnCheckedChangeListener { _, isChecked ->
        product.isChecked = isChecked
        (context as? ProductsActivity)?.updateCheckoutButtonStatus()
      }
      product_checkbox.isChecked = product.isChecked
    }
  }

  class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}