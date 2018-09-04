package com.jackyli.salestax.domain.audit.usecase

import com.jackyli.salestax.data.audit.Audit
import com.jackyli.salestax.data.audit.AuditRepository
import com.jackyli.salestax.data.store.AuthStore
import com.jackyli.salestax.domain.util.changeToMainThread
import io.reactivex.Observable
import javax.inject.Inject

class AuditUseCase @Inject constructor(private val auditRepository: AuditRepository) {
  fun getAudit(): Observable<Audit> {
    return Observable.fromIterable(AuthStore.instance.auditIds)
            .flatMap {
              auditRepository.loadAudit(it).toObservable()
            }.changeToMainThread()
  }
}