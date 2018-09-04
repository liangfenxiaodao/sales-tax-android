package com.jackyli.salestax.audits.sections.di

import android.content.Context
import com.jackyli.salestax.audits.sections.SectionsAdapter
import com.jackyli.salestax.audits.sections.SectionsPresenter
import com.jackyli.salestax.di.scope.PerActivity
import com.jackyli.salestax.domain.audit.usecase.AuditUseCase
import dagger.Module
import dagger.Provides

@Module
class SectionsModule {
  @Provides
  @PerActivity
  fun provideSectionsAdapter(context: Context): SectionsAdapter = SectionsAdapter(context)

  @Provides
  @PerActivity
  fun provideSectionsPresenter(auditUseCase: AuditUseCase): SectionsPresenter = SectionsPresenter(auditUseCase)

}