package com.jackyli.salestax.audits

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jackyli.salestax.R
import com.jackyli.salestax.audits.sections.SectionsActivity
import com.jackyli.salestax.data.audit.Audit
import com.jackyli.salestax.utils.launchActivity
import kotlinx.android.synthetic.main.card_view_audit.view.*
import javax.inject.Inject

class AuditAdapter @Inject constructor(private val context: Context) : RecyclerView.Adapter<AuditAdapter.ViewHolder>() {
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
      card_view_audit_total_score.text = "Total score: " + audit.auditData?.totalScore
      card_view_audit_status.text = "Archived: " + audit.archived.toString()
      val completed = audit.auditData?.dateCompleted != null
      card_view_audit_completed_status.text = "Completed: " + completed.toString()

      setOnClickListener {
        showSections(audit.auditId)
      }
    }
  }

  private fun showSections(auditId: String) {
    context.launchActivity<SectionsActivity> {
      addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
      putExtra("auditId", auditId)
    }
  }

  fun addAudit(audit: Audit) {
    audits.add(audit)
  }


  class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)

}