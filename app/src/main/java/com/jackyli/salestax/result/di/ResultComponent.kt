package com.jackyli.salestax.result.di

import com.jackyli.salestax.di.component.ApplicationComponent
import com.jackyli.salestax.di.scope.PerActivity
import com.jackyli.salestax.result.ResultActivity
import dagger.Component

@PerActivity
@Component(modules = [ResultModule::class], dependencies = [ApplicationComponent::class])
interface ResultComponent {
  fun inject(resultActivity: ResultActivity)
}