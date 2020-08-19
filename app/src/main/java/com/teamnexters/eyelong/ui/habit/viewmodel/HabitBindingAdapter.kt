package com.teamnexters.eyelong.ui.habit.viewmodel

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.teamnexters.eyelong.db.entity.Habit
import com.teamnexters.eyelong.ui.habit.adapter.HabitRecyclerViewAdapter

@BindingAdapter("items")
fun bindItems(view: RecyclerView, items: List<Habit>) {
    val adapter = view.adapter as? HabitRecyclerViewAdapter
        ?: HabitRecyclerViewAdapter().apply { view.adapter = this }
    adapter.items = items
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
        val resId = resources.getIdentifier(imagePath, "drawable", packageName)
        Glide.with(this).load(resId).into(view)
    }
}