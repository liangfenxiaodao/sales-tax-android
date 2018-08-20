package com.jackyli.salestax.domain.product.model

class BaseTaxCalculator(private val taxable: Taxable) : TaxCalculator(taxable) {
  private val baseTaxRate = 0.1f

  override fun getTax(): Float {
    if (taxable.isExempted()) return 0f
    return taxable.getTax() + baseTaxRate * taxable.getPrice()
  }
}