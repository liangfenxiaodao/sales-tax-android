package com.jackyli.domain.product.model

class Product(product: com.jackyli.data.products.model.Product) {
  val name: String? = product.name
  val price: Float = product.price?.toFloat() ?: 0f
  val imported: Boolean = product.imported?.toBoolean() ?: false
}