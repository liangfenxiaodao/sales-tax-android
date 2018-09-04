package com.jackyli.salestax.audits.sections

import com.jackyli.salestax.BasePresenter
import com.jackyli.salestax.data.store.AuthStore
import com.jackyli.salestax.domain.audit.usecase.AuditUseCase
import javax.inject.Inject

class SectionsPresenter @Inject constructor(private val auditUseCase: AuditUseCase) : BasePresenter<SectionsActivity>() {
  fun getSections(auditId: String) {
    val audit = AuthStore.instance.audits[auditId]
    val items = audit?.items?.filter { it.type == "section" } ?: emptyList()
    getView()?.showSections(items)
  }
}