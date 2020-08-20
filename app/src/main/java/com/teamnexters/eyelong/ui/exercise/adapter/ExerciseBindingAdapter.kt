package com.teamnexters.eyelong.ui.exercise.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.teamnexters.eyelong.db.entity.Exercise

@BindingAdapter("items")
fun bindItems(view: RecyclerView, items: List<Exercise>) {
    val adapter = view.adapter as? EyeExerciseTest
        ?: EyeExerciseTest().apply { view.adapter = this }
    adapter.items = items
    adapter.notifyDataSetChanged()
}

@BindingAdapter("observer")
fun bindObserver(view: RecyclerView, observer: EyeExerciseTest.Observer) {
    val adapter = view.adapter as? EyeExerciseTest
        ?: EyeExerciseTest().apply { view.adapter = this }
    adapter.observer = observer
}
