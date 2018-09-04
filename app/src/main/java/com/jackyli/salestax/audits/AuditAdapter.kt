package com.jackyli.salestax.audits

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jackyli.salestax.R
import com.jackyli.salestax.data.audit.Audit
import kotlinx.android.synthetic.main.card_view_audit.view.*

class AuditAdapter : RecyclerView.Adapter<AuditAdapter.ViewHolder>() {
  var audits: MutableList<Audit> = emptyList<Audit>().toMutableList()

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_audit, parent, false)
    return ViewHolder(view)
  }

  override fun getItemCount(): Int {
    return audits.size
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val audit = audits[position]
    holder.view.apply {
      card_view_audit_name.text = audit.auditData?.name
      card_view_audit_owner.text = "Owner: " + audit.auditData?.authorship?.owner
      card_view_audit_score.text = "Score: " + audit.auditData?.score
      card_view_audit_status.text = "Archived: " + audit.archived.toString()
      val completed = audit.auditData?.dateCompleted != null
      card_view_audit_completed_status.text = "Completed: " + completed.toString()
    }
  }

  fun addAudit(audit: Audit) {
    audits.add(audit)
  }


  class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)

}