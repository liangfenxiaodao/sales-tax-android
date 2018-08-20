package com.jackyli.salestax.domain.product.model

class ImportedTaxCalculator(private val taxable: Taxable) : TaxCalculator(taxable) {
  private val importedTaxRate = 0.05f

  override fun getTax(): Float {
    return taxable.getTax() + importedTaxRate * taxable.getPrice()
  }
}