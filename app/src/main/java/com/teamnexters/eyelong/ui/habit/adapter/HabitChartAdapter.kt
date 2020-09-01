package com.teamnexters.eyelong.ui.habit.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.teamnexters.eyelong.db.entity.Habit

class HabitChartAdapter(private val items: List<Habit>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        TODO("Not yet implemented")
    }

    override fun getItem(position: Int) = items[position]
    override fun getItemId(position: Int) = position.toLong()
    override fun getCount() = items.size
}