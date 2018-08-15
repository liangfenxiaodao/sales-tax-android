package com.jackyli.salestax

import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter<out T> {
  private var view: T? = null
  protected val disposables = CompositeDisposable()

  @Suppress("UNCHECKED_CAST")
  fun attachView(view: Any?){
    this.view = view as T?
  }

  fun getView(): T? = view

  fun detachView() {
    view = null
  }

  fun disposeSubscriptions() {
    disposables.dispose()
  }
}