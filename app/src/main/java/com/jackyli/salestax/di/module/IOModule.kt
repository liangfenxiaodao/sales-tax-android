package com.jackyli.salestax.di.module

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jackyli.salestax.data.RestfulAPI
import com.jackyli.salestax.domain.util.BuildFlavor
import com.jackyli.salestax.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class IOModule(val context: Context) {
  private val okHttpClient: OkHttpClient
  private val gson: Gson = GsonBuilder().create()
  private val restfulAPI: RestfulAPI
  private val cacheDir: File = context.cacheDir

  init {
    okHttpClient = getOkHttpBuilder().build()
    restfulAPI = getRetrofitBuilder().build().create(RestfulAPI::class.java)
  }

  private fun getRetrofitBuilder(): Retrofit.Builder {
    return Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("https://api.myjson.com/")
            .client(okHttpClient)
  }

  private fun getOkHttpBuilder(): OkHttpClient.Builder {
    val cacheSize = 200 * 1024 * 1024L
    val cache = Cache(cacheDir, cacheSize)

    val builder = OkHttpClient.Builder()
            .connectTimeout(40, TimeUnit.SECONDS)
            .writeTimeout(40, TimeUnit.SECONDS)
            .readTimeout(40, TimeUnit.SECONDS)
            .cache(cache)
    if (BuildConfig.FLAVOR == BuildFlavor.DEV.flavor) {
      builder.addInterceptor { chain ->
        println(chain.request())
        println(chain.request().headers().toMultimap().toString())
        chain.proceed(chain.request())
      }
    }
    return builder
  }

  @Provides
  @Singleton
  fun provideRestfulAPI(): RestfulAPI = restfulAPI
}