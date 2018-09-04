package com.jackyli.salestax.audits

import com.jackyli.salestax.BasePresenter
import com.jackyli.salestax.data.audit.Audit
import com.jackyli.salestax.domain.audit.usecase.AuditUseCase
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class AuditPresenter @Inject constructor(private val auditUseCase: AuditUseCase) : BasePresenter<AuditActivity>() {
  fun loadAudits() {
    val disposable = auditUseCase.getAudit().subscribeWith(
            object : DisposableObserver<Audit>() {
              override fun onComplete() {
              }

              override fun onNext(t: Audit) {
                getView()?.addAudit(t)
              }

              override fun onError(e: Throwable) {
              }
            })

    disposables.add(disposable)
  }


}