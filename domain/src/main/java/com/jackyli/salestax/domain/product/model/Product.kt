package com.jackyli.salestax.domain.product.model

import com.jackyli.salestax.data.products.model.Product

class Product(val product: Product) : Taxable {
  var isChecked: Boolean = false
  var id: String = product.id ?: ""

  override fun getTax(): Float {
    return 0f
  }

  override fun getPrice(): Float {
    return product.price?.toFloat() ?: 0f
  }

  override fun isExempted(): Boolean {
    return this.getName().let {
      it.contains("book") || it.contains("chocolate") || it.contains("headache pill")
    }
  }

  override fun isImported(): Boolean {
    return product.imported?.toBoolean() ?: false
  }

  override fun getName(): String {
    return product.name ?: ""
  }
}