package com.jackyli.salestax

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.toolbar.*

abstract class BaseActivity<out P : BasePresenter<Any>> : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(getLayout())
    initialiseInjector()
    setSupportActionBar(toolbar)
    getPresenter().attachView(this)
    initialiseView()
  }

  override fun onDestroy() {
    getPresenter().disposeSubscriptions()
    getPresenter().detachView()
    super.onDestroy()
  }

  protected abstract fun getPresenter(): P
  protected abstract fun initialiseView()
  protected abstract fun initialiseInjector()
  protected abstract fun getLayout(): Int
}