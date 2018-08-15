package com.jackyli.salestax.domain.product.model

import com.jackyli.salestax.data.products.model.Product

class Product(product: Product) {
  val name: String? = product.name
  val price: Float = product.price?.toFloat() ?: 0f
  val imported: Boolean = product.imported?.toBoolean() ?: false
}