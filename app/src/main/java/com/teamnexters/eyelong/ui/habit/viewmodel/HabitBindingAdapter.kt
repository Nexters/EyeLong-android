package com.teamnexters.eyelong.ui.habit.viewmodel

import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.db.entity.Habit
import com.teamnexters.eyelong.ui.habit.adapter.HabitAchieveViewAdapter
import com.teamnexters.eyelong.ui.habit.adapter.HabitChartViewAdapter
import com.teamnexters.eyelong.ui.habit.adapter.HabitRecyclerViewAdapter
import com.teamnexters.eyelong.ui.habit.chart.Item

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
        ?: HabitRecyclerViewAdapter(itemType).apply {
            setHasStableIds(true)
            view.adapter = this
        }

    adapter.items = items
    adapter.observer = observer
    adapter.notifyDataSetChanged()
}

@BindingAdapter("chartItems")
fun bindChartItems(
    view: RecyclerView,
    items: ObservableArrayList<Item>
) {
    val adapter = view.adapter as? HabitChartViewAdapter
        ?: HabitChartViewAdapter().apply {
            view.adapter = this
        }

    adapter.items = items
    adapter.notifyDataSetChanged()
}

@BindingAdapter("achieveItems")
fun bindAchieveItems(
    view: RecyclerView,
    items: ObservableArrayList<Habit>
) {
    val adapter = view.adapter as? HabitAchieveViewAdapter
        ?: HabitAchieveViewAdapter().apply {
            view.adapter = this
        }

    adapter.items = items
    adapter.notifyDataSetChanged()
}

@BindingAdapter("divider")
fun bindDivider(view: RecyclerView, drawable: Drawable) {
    val layoutManager = view.layoutManager as? LinearLayoutManager
        ?: LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false).apply {
            view.layoutManager = this
        }

    layoutManager.let {
        object : DividerItemDecoration(view.context, it.orientation) {
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                if (parent.getChildAdapterPosition(view) == state.itemCount - 1) {
                    outRect.setEmpty()
                } else {
                    super.getItemOffsets(outRect, view, parent, state)
                }
            }
        }.apply {
            setDrawable(drawable)
        }.also {
            view.addItemDecoration(it)
        }
    }
}

@BindingAdapter("icon")
fun bindIcon(view: ImageView, imagePath: String?) {
    view.context.run {
        val drawable = getDrawable(resources.getIdentifier(imagePath, "drawable", packageName))
        view.setImageDrawable(drawable)
    }
}