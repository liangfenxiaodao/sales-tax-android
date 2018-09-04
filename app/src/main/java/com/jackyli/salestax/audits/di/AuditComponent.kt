package com.jackyli.salestax.audits.di

import com.jackyli.salestax.audits.AuditActivity
import com.jackyli.salestax.di.component.ApplicationComponent
import com.jackyli.salestax.di.scope.PerActivity
import dagger.Component

@PerActivity
@Component(modules = [AuditModule::class], dependencies = [ApplicationComponent::class])
interface AuditComponent {
  fun inject(auditActivity: AuditActivity)
}