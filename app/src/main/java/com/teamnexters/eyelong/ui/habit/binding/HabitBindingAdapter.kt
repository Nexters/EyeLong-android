package com.teamnexters.eyelong.ui.habit.binding

import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.db.entity.Habit
import com.teamnexters.eyelong.ui.habit.adapter.HabitChartViewAdapter
import com.teamnexters.eyelong.ui.habit.adapter.HabitRecyclerViewAdapter
import com.teamnexters.eyelong.ui.habit.adapter.HabitSuggestViewAdapter
import com.teamnexters.eyelong.ui.habit.chart.Item

@BindingAdapter(value = ["items", "observer"], requireAll = true)
fun bindHabitItems(
    view: RecyclerView,
    items: ObservableArrayList<Habit>,
    observer: HabitRecyclerViewAdapter.Observer
) {
    val itemType = when (view.id) {
        R.id.recycler_habit_checkout -> HabitRecyclerViewAdapter.ItemType.CHECKOUT
        else -> HabitRecyclerViewAdapter.ItemType.EDIT
    }

    val adapter = view.adapter as? HabitRecyclerViewAdapter
        ?: HabitRecyclerViewAdapter(itemType).apply {
            setHasStableIds(true)
            view.adapter = this
        }

    adapter.items = items
    adapter.observer = observer
    adapter.notifyDataSetChanged()
}

@BindingAdapter("items")
fun bindChartItems(
    view: RecyclerView,
    items: ObservableArrayList<Item>
) {
    val adapter = view.adapter as? HabitChartViewAdapter
        ?: HabitChartViewAdapter().apply {
            view.adapter = this
            view.layoutManager =
                LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
        }

    adapter.items = items
    adapter.notifyDataSetChanged()
}

@BindingAdapter("items")
fun bindSuggestItems(
    view: RecyclerView,
    items: ObservableArrayList<Habit>
) {
    val adapter = view.adapter as? HabitSuggestViewAdapter
        ?: HabitSuggestViewAdapter().apply {
            view.adapter = this
        }

    adapter.items = items
    adapter.notifyDataSetChanged()
}
