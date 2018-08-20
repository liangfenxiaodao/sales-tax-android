package com.jackyli.salestax.domain.product.model

interface Taxable {
  fun getName(): String
  fun getTax(): Float
  fun getPrice(): Float
  fun isImported(): Boolean
  fun isExempted(): Boolean
}