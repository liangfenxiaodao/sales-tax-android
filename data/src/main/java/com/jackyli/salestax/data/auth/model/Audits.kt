package com.jackyli.salestax.data.auth.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Audits {
  @SerializedName("count")
  @Expose
  var count: Int? = null
  @SerializedName("total")
  @Expose
  var total: Int? = null
  @SerializedName("audits")
  @Expose
  var audits: List<Audit>? = null
}