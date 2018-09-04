package com.jackyli.salestax.data.audit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AuditItem {

  @SerializedName("item_id")
  @Expose
  var itemId: String? = null

  @SerializedName("parent_id")
  @Expose
  var parentId: String? = null

  @SerializedName("label")
  @Expose
  var label: String? = null

  @SerializedName("type")
  @Expose
  var type: String? = null

  @SerializedName("responses")
  @Expose
  var response: Response? = null

  @SerializedName("children")
  @Expose
  var children: List<String>? = null
}
