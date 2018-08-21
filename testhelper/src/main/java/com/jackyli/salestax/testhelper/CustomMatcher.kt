package com.jackyli.salestax.testhelper

import org.mockito.Mockito

object CustomMatcher {
  fun <T> any(): T {
    Mockito.any<T>()
    return uninitialized()
  }

  fun <T> any(type: Class<T>): T {
    Mockito.any<T>(type)
    return uninitialized()
  }

  fun anyString(): String {
    Mockito.anyString()
    return uninitialized()
  }

  @Suppress("UNCHECKED_CAST")
  private fun <T> uninitialized(): T = null as T
}