package com.jackyli.salestax.audits.sections

import androidx.recyclerview.widget.LinearLayoutManager
import com.jackyli.salestax.BaseActivity
import com.jackyli.salestax.MainApplication
import com.jackyli.salestax.R
import com.jackyli.salestax.audits.sections.di.DaggerSectionsComponent
import com.jackyli.salestax.audits.sections.di.SectionsModule
import com.jackyli.salestax.data.audit.Audit
import com.jackyli.salestax.data.audit.AuditItem
import kotlinx.android.synthetic.main.activity_audits.*
import kotlinx.android.synthetic.main.activity_sections.*
import javax.inject.Inject

class SectionsActivity : BaseActivity<SectionsPresenter>() {
  @Inject
  lateinit var sectionsPresenter: SectionsPresenter

  @Inject
  lateinit var sectionsAdapter: SectionsAdapter

  override fun getPresenter(): SectionsPresenter {
    return sectionsPresenter
  }

  override fun initialiseView() {
    title = "Sections"
    with(sections_recycler_view) {
      setHasFixedSize(true)
      layoutManager = LinearLayoutManager(context)
      adapter = sectionsAdapter
      setItemViewCacheSize(10)
    }
    sectionsPresenter.getSections(intent.getStringExtra("auditId"))
  }

  override fun initialiseInjector() {
    DaggerSectionsComponent.builder()
            .applicationComponent((application as MainApplication).applicationComponent)
            .sectionsModule(SectionsModule())
            .build()
            .inject(this)
  }

  override fun getLayout(): Int {
    return R.layout.activity_sections
  }

  fun showSections(items: List<AuditItem>) {
    sectionsAdapter.sections = items
    sectionsAdapter.notifyDataSetChanged()
  }
}