package com.teamnexters.eyelong.ui.binding

import android.content.Context
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.db.entity.Habit
import com.teamnexters.eyelong.ui.habit.adapter.HabitChartViewAdapter
import com.teamnexters.eyelong.ui.habit.adapter.HabitRecyclerViewAdapter
import com.teamnexters.eyelong.ui.habit.adapter.HabitSuggestViewAdapter
import com.teamnexters.eyelong.ui.habit.chart.Item
import java.time.Duration
import java.time.LocalTime

fun LocalTime.format() = String.format("%02d : %02d", hour, minute)
fun LocalTime.meridiem(context: Context) =
    context.getString(if (hour >= 12) R.string.post_meridiem else R.string.ante_meridiem)

fun LocalTime.count(start: LocalTime, end: LocalTime) = if (start.isAfter(end)) {
    val diff = Duration.ofDays(1).toNanos() - start.toNanoOfDay()
    diff + end.toNanoOfDay()
} else {
    Duration.between(start, end).toNanos()
}.let { it / toNanoOfDay() }

@BindingAdapter(value = ["items", "observer"], requireAll = false)
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

@BindingAdapter("suggestItems")
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

@BindingAdapter("meridiem")
fun bindMeridiem(view: TextView, time: LocalTime?) {
    view.apply {
        text = time?.meridiem(context) ?: context.getString(R.string.ante_meridiem)
        isEnabled = time != null
    }
}

@BindingAdapter("time")
fun bindTime(view: TextView, time: LocalTime?) {
    view.apply {
        text = time?.format() ?: context.getString(R.string.clock)
        isEnabled = time != null
    }
}
