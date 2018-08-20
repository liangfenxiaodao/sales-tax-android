package com.jackyli.salestax.data.products.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Product {
  @SerializedName("id")
  @Expose
  var id: String? = null
  @SerializedName("name")
  @Expose
  var name: String? = null
  @SerializedName("price")
  @Expose
  var price: String? = null
  @SerializedName("imported")
  @Expose
  var imported: String? = null
}