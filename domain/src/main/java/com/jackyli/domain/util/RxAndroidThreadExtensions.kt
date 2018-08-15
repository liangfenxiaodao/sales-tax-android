package com.jackyli.domain.util

import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers

fun <T> Single<T>.changeToMainThread(): Single<T> = observeOn(AndroidSchedulers.mainThread())
fun <T> Observable<T>.changeToMainThread(): Observable<T> = observeOn(AndroidSchedulers.mainThread())