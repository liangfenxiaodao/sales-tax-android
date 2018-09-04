package com.jackyli.salestax.audits.di

import com.jackyli.salestax.audits.AuditAdapter
import com.jackyli.salestax.audits.AuditPresenter
import com.jackyli.salestax.di.scope.PerActivity
import com.jackyli.salestax.domain.audit.usecase.AuditUseCase
import dagger.Module
import dagger.Provides

@Module
class AuditModule {
  @Provides
  @PerActivity
  fun provideAuditAdapter(): AuditAdapter = AuditAdapter()

  @Provides
  @PerActivity
  fun provideAuditPresenter(auditUseCase: AuditUseCase): AuditPresenter = AuditPresenter(auditUseCase)

}