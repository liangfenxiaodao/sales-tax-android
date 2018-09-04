package com.jackyli.salestax.data.audit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AuthorShip {
  @SerializedName("owner")
  @Expose
  var owner: String? = null
}
