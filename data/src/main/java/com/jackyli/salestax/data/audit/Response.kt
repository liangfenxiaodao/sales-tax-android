package com.jackyli.salestax.data.audit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Response {

  @SerializedName("failed")
  @Expose
  var failed: Boolean = false
}