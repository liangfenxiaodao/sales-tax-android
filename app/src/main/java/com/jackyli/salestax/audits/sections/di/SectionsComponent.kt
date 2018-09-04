package com.jackyli.salestax.audits.sections.di

import com.jackyli.salestax.audits.AuditActivity
import com.jackyli.salestax.audits.sections.SectionsActivity
import com.jackyli.salestax.di.component.ApplicationComponent
import com.jackyli.salestax.di.scope.PerActivity
import dagger.Component

@PerActivity
@Component(modules = [SectionsModule::class], dependencies = [ApplicationComponent::class])
interface SectionsComponent {
  fun inject(sectionsActivity: SectionsActivity)
}