package com.jackyli.salestax.data.audit

import com.jackyli.salestax.data.RestfulAPI
import com.jackyli.salestax.data.extensions.subscribeOnIO
import com.jackyli.salestax.data.store.AuthStore
import io.reactivex.Single
import javax.inject.Inject

class AuditRepository @Inject constructor(private val restfulAPI: RestfulAPI) {
  fun loadAudit(auditId: String): Single<Audit> {
    return restfulAPI.getAudit(auditId)
            .subscribeOnIO()
            .doOnSuccess {
              AuthStore.instance.audits[it.auditId] = it
            }
  }
}