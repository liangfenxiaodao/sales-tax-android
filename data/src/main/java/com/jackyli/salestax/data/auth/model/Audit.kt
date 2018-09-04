package com.jackyli.salestax.data.auth.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Audit {
  @SerializedName("audit_id")
  @Expose
  var auditId: String = ""
  @SerializedName("modified_at")
  @Expose
  var modifiedAt: String? = null
  @SerializedName("template_id")
  @Expose
  var templateId: String? = null
}