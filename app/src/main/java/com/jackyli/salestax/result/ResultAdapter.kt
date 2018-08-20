package com.jackyli.salestax.result

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jackyli.salestax.R
import com.jackyli.salestax.domain.product.model.TaxCalculator
import kotlinx.android.synthetic.main.item_result.view.*

class ResultAdapter : RecyclerView.Adapter<ResultAdapter.ViewHolder>() {
  var items: List<TaxCalculator>? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.item_result, parent, false)
    return ViewHolder(view)
  }

  override fun getItemCount(): Int = items?.count() ?: 0

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val item = items?.get(position) ?: return
    holder.view.apply {
      result_product_name.text = item.getName()
      result_product_price.text = item.getTaxedPrice().toString()
    }
  }

  class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}