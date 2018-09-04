package com.jackyli.salestax.data.audit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Audit {
  @SerializedName("audit_id")
  @Expose
  var auditId: String = ""

  @SerializedName("archived")
  @Expose
  var archived: Boolean? = null

  @SerializedName("audit_data")
  @Expose
  var auditData: AuditData? = null

  @SerializedName("items")
  @Expose
  var items: List<AuditItem>? = null
}