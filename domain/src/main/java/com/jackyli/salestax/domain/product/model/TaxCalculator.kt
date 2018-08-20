package com.jackyli.salestax.domain.product.model

import java.math.BigDecimal
import java.math.RoundingMode

abstract class TaxCalculator(private val taxable: Taxable) : Taxable {
  override fun getPrice(): Float {
    return taxable.getPrice()
  }

  fun getTaxedPrice(): Float {
    return taxable.getPrice() + getRoundingTax()
  }

  private fun getRoundingTax(): Float {
    return BigDecimal(Math.ceil((getTax() * 20).toDouble()) / 20).setScale(2, RoundingMode.HALF_UP).toFloat()
  }

  override fun isImported(): Boolean {
    return taxable.isImported()
  }

  override fun isExempted(): Boolean {
    return taxable.isExempted()
  }

  override fun getName(): String {
    return taxable.getName()
  }
}