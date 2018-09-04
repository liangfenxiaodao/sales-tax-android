package com.jackyli.salestax.audits.sections

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jackyli.salestax.R
import com.jackyli.salestax.data.audit.AuditItem
import kotlinx.android.synthetic.main.card_view_section.view.*

class SectionsAdapter : RecyclerView.Adapter<SectionsAdapter.ViewHolder>() {
  var sections: List<AuditItem> = emptyList()

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_section, parent, false)
    return ViewHolder(view)
  }

  override fun getItemCount(): Int {
    return sections.size
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val section = sections[position]
    println(section)
    holder.view.apply {
      card_view_section_name.text = section.label
    }
  }

  class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}