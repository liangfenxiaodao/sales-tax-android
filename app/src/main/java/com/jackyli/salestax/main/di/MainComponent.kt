package com.jackyli.salestax.main.di

import com.jackyli.salestax.di.component.ApplicationComponent
import com.jackyli.salestax.di.scope.PerActivity
import com.jackyli.salestax.main.MainActivity
import dagger.Component

@PerActivity
@Component(modules = [MainModule::class], dependencies = [ApplicationComponent::class])
interface MainComponent {
  fun inject(mainActivity: MainActivity)
}