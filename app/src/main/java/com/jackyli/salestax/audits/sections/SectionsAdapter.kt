package com.jackyli.salestax.audits.sections

import android.content.Context
import android.opengl.Visibility
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jackyli.salestax.R
import com.jackyli.salestax.data.audit.AuditItem
import com.jackyli.salestax.data.store.AuthStore
import kotlinx.android.synthetic.main.card_view_section.view.*
import android.widget.TextView
import javax.inject.Inject
import android.widget.LinearLayout


class SectionsAdapter @Inject constructor(private val context: Context) : RecyclerView.Adapter<SectionsAdapter.ViewHolder>() {
  var sections: List<AuditItem> = emptyList()
  lateinit var auditId: String

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_section, parent, false)
    return ViewHolder(view)
  }

  override fun getItemCount(): Int {
    return sections.size
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val section = sections[position]
    holder.view.apply {
      card_view_section_name.text = section.label
      card_view_category_items.visibility = View.GONE

      setOnClickListener {
        showSectionDetail(it, section)
      }
    }
  }

  private fun showSectionDetail(sectionCardView: View, section: AuditItem) {
    println("------------- showSectionDetail -------------")
    val audit = AuthStore.instance.audits[auditId]
    val items = audit?.items?.filter { it.parentId == section.itemId }
    items?.forEach {
      val textView = TextView(context)
      textView.setPadding(0, 20, 0, 20)
      textView.gravity = Gravity.LEFT
      val layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
      sectionCardView.card_view_category_items.addView(textView, layoutParams)
    }

    for (i in 0 until items!!.size) {
      (sectionCardView.card_view_category_items.getChildAt(i) as TextView).text = items[i].label
    }
    sectionCardView.card_view_category_items.visibility = if (sectionCardView.card_view_category_items.visibility == View.VISIBLE) {
      View.GONE
    } else {
      View.VISIBLE
    }
  }

  class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}