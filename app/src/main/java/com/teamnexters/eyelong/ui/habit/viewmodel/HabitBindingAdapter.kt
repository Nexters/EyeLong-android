package com.teamnexters.eyelong.ui.habit.viewmodel

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.teamnexters.eyelong.db.entity.Habit
import com.teamnexters.eyelong.ui.habit.adapter.HabitRecyclerViewAdapter

@BindingAdapter("items")
fun bindItems(view: RecyclerView, items: List<Habit>) {
    val adapter = view.adapter as? HabitRecyclerViewAdapter
        ?: HabitRecyclerViewAdapter().apply { view.adapter = this }
    adapter.items = items
    adapter.notifyDataSetChanged()
}