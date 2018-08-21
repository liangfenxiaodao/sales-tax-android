package com.jackyli.salestax.testhelper

import com.google.gson.Gson
import org.apache.commons.io.IOUtils
import java.nio.charset.Charset

object FakeObjectProvider {
  inline fun <reified T> fromJson(jsonFile: String): T {
    val inputStream = javaClass.classLoader.getResourceAsStream(jsonFile)
    val string = IOUtils.toString(inputStream, Charset.defaultCharset())
    return Gson().fromJson(string, T::class.java)
  }
}