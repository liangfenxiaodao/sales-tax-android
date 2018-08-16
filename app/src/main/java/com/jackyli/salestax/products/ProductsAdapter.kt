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

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
    return ViewHolder(view)
  }

  override fun getItemCount(): Int = products?.count() ?: 0

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val product = products?.get(position) ?: return
    holder.view.apply {
      product_name.text = product.name
      product_price.text = product.price.toString()
      product_imported.text = product.imported.toString()
    }
  }

  class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}