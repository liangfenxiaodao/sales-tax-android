package com.jackyli.salestax.data.audit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AuditData {
  @SerializedName("total_score")
  @Expose
  var totalScore: String? = null

  @SerializedName("score")
  @Expose
  var score: String? = null

  @SerializedName("name")
  @Expose
  var name: String? = null

  @SerializedName("authorship")
  @Expose
  var authorship: AuthorShip? = null

  @SerializedName("date_completed")
  @Expose
  var dateCompleted: String? = null
}
