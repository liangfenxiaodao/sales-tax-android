package com.jackyli.salestax.data.products.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Products {
  @SerializedName("products")
  @Expose
  var products: List<Product>? = null
}