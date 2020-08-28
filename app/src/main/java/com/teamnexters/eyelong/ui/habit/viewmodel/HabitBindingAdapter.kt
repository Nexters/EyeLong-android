package com.teamnexters.eyelong.ui.habit.viewmodel

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.db.entity.Habit
import com.teamnexters.eyelong.ui.habit.adapter.HabitRecyclerViewAdapter

@BindingAdapter(value = ["items", "observer"], requireAll = false)
fun bindItems(
    view: RecyclerView,
    items: ObservableArrayList<Habit>,
    observer: HabitRecyclerViewAdapter.Observer
) {
    val itemType = when (view.id) {
        R.id.recycler_habit_checkout -> HabitRecyclerViewAdapter.ItemType.CHECKOUT
        else -> HabitRecyclerViewAdapter.ItemType.EDIT
    }

    val adapter = view.adapter as? HabitRecyclerViewAdapter
        ?: HabitRecyclerViewAdapter(itemType).apply { view.adapter = this }

    adapter.items = items
    adapter.observer = observer
    adapter.notifyDataSetChanged()
}

@BindingAdapter("divider")
fun bindDivider(view: RecyclerView, drawable: Drawable) {
    DividerItemDecoration(view.context, LinearLayoutManager.VERTICAL).apply {
        setDrawable(drawable)
    }.also {
        view.addItemDecoration(it)
    }
}

@BindingAdapter("icon")
fun bindIcon(view: ImageView, imagePath: String?) {
    view.context.run {
        val drawable = getDrawable(resources.getIdentifier(imagePath, "drawable", packageName))
        view.setImageDrawable(drawable)
    }
}