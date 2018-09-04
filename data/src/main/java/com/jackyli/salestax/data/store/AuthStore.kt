package com.jackyli.salestax.data.store

import com.jackyli.salestax.data.audit.Audit

class AuthStore private constructor() {
  private object Holder {
    val INSTANCE = AuthStore()
  }

  companion object {
    val instance: AuthStore by lazy { AuthStore.Holder.INSTANCE }
  }

  var token: String? = null
  var auditIds: List<String>? = null
  var audits: MutableMap<String, Audit> = emptyMap<String, Audit>().toMutableMap()
}