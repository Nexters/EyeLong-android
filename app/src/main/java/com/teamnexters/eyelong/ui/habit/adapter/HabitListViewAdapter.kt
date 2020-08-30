package com.teamnexters.eyelong.ui.habit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.teamnexters.eyelong.BR
import com.teamnexters.eyelong.databinding.ItemHabitAnalyticsListBinding
import com.teamnexters.eyelong.db.entity.Habit

class HabitListViewAdapter(private val items: List<Habit>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        val itemView: View?

        if (convertView != null) {
            itemView = convertView
        } else {
            ItemHabitAnalyticsListBinding.inflate(
                LayoutInflater.from(parent?.context),
                parent,
                false
            ).apply {
                tvHabitBadge.text = "${position + 1}"
                setVariable(BR.habit, items[position])
            }.also {
                itemView = it.root
            }
        }

        return itemView
    }

    override fun getItem(position: Int) = items[position]
    override fun getItemId(position: Int) = position.toLong()
    override fun getCount() = items.size
}
