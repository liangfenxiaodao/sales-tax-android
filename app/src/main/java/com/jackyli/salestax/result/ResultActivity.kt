package com.jackyli.salestax.result

import androidx.recyclerview.widget.LinearLayoutManager
import com.jackyli.salestax.BaseActivity
import com.jackyli.salestax.MainApplication
import com.jackyli.salestax.R
import com.jackyli.salestax.domain.product.model.TaxCalculator
import com.jackyli.salestax.result.di.DaggerResultComponent
import com.jackyli.salestax.result.di.ResultModule
import kotlinx.android.synthetic.main.activity_result.*
import javax.inject.Inject

class ResultActivity : BaseActivity<ResultPresenter>() {
  @Inject
  lateinit var resultPresenter: ResultPresenter

  val resultAdapter = ResultAdapter()

  override fun getPresenter(): ResultPresenter = resultPresenter

  override fun initialiseView() {
    with(result_items_recycler_view) {
      setHasFixedSize(true)
      layoutManager = LinearLayoutManager(context)
      adapter = resultAdapter
      setItemViewCacheSize(10)
    }
    getPresenter().calculateResult(intent.getStringArrayExtra("idList"))
  }

  override fun initialiseInjector() {
    DaggerResultComponent.builder()
            .applicationComponent((application as MainApplication).applicationComponent)
            .resultModule(ResultModule())
            .build()
            .inject(this)
  }

  override fun getLayout(): Int {
    return R.layout.activity_result
  }

  fun displayResult(taxCalculators: List<TaxCalculator>) {
    taxCalculators.forEach {
      println(it.getTaxedPrice())
    }
    resultAdapter.items = taxCalculators
    resultAdapter.notifyDataSetChanged()
    val totalPrice = taxCalculators.map { it.getPrice() }.reduce { acc, element -> acc + element }
    val totalTaxedPrice = taxCalculators.map { it.getTaxedPrice() }.reduce { acc, element -> acc + element }
    total_price.text = totalTaxedPrice.toString()
    total_taxes.text = (totalTaxedPrice - totalPrice).toString()
  }
}