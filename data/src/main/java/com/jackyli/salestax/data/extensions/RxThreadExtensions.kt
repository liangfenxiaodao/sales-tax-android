package com.jackyli.salestax.data.extensions

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

fun <T> Single<T>.subscribeOnIO(): Single<T> = subscribeOn(Schedulers.io())
fun <T> Observable<T>.subscribeOnIO(): Observable<T> = subscribeOn(Schedulers.io())
fun Completable.subscribeOnIO(): Completable = subscribeOn(Schedulers.io())