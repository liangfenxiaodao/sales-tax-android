package com.jackyli.salestax.audits

import androidx.recyclerview.widget.LinearLayoutManager
import com.jackyli.salestax.BaseActivity
import com.jackyli.salestax.MainApplication
import com.jackyli.salestax.R
import com.jackyli.salestax.audits.di.AuditModule
import com.jackyli.salestax.audits.di.DaggerAuditComponent
import com.jackyli.salestax.data.audit.Audit
import kotlinx.android.synthetic.main.activity_audits.*
import javax.inject.Inject

class AuditActivity : BaseActivity<AuditPresenter>() {
  @Inject
  lateinit var auditPresenter: AuditPresenter

  @Inject
  lateinit var auditAdapter: AuditAdapter

  override fun getPresenter(): AuditPresenter {
    return auditPresenter
  }

  override fun initialiseView() {
    with(audits_recycler_view) {
      setHasFixedSize(true)
      layoutManager = LinearLayoutManager(context)
      adapter = auditAdapter
      setItemViewCacheSize(10)
    }
    auditPresenter.loadAudits()
  }

  override fun initialiseInjector() {
    DaggerAuditComponent.builder()
            .applicationComponent((application as MainApplication).applicationComponent)
            .auditModule(AuditModule())
            .build()
            .inject(this)
  }

  override fun getLayout(): Int {
    return R.layout.activity_audits
  }

  fun addAudit(audit: Audit) {
    auditAdapter.addAudit(audit)
    auditAdapter.notifyDataSetChanged()
  }
}