package com.jackyli.salestax.data.auth.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Auth {
  @SerializedName("access_token")
  @Expose
  var token: String? = null
}