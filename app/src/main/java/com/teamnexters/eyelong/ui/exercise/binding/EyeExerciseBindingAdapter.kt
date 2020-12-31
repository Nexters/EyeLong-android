package com.teamnexters.eyelong.ui.exercise.binding

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.RecyclerView
import com.teamnexters.eyelong.db.entity.Exercise
import com.teamnexters.eyelong.ui.exercise.adapter.EyeExerciseEditRecyclerViewAdapter
import com.teamnexters.eyelong.ui.exercise.adapter.EyeExerciseRecyclerViewAdapter

@BindingAdapter(value = ["items", "observer"], requireAll = false)
fun bindExerciseItems(
    view: RecyclerView,
    items: ObservableArrayList<Exercise>,
    observer: EyeExerciseRecyclerViewAdapter.Observer
) {
    val adapter = view.adapter as? EyeExerciseRecyclerViewAdapter
        ?: EyeExerciseRecyclerViewAdapter().apply {
            view.adapter = this
        }

    adapter.items = items
    adapter.observer = observer
    adapter.notifyDataSetChanged()
}

@BindingAdapter(value = ["items", "observer"], requireAll = false)
fun bindExerciseEditItems(
    view: RecyclerView,
    items: ObservableArrayList<Exercise>,
    observer: EyeExerciseEditRecyclerViewAdapter.Observer
) {
    val adapter = view.adapter as? EyeExerciseEditRecyclerViewAdapter
        ?: EyeExerciseEditRecyclerViewAdapter().apply {
            view.adapter = this
        }

    adapter.items = items
    adapter.observer = observer
    adapter.notifyDataSetChanged()
}

@BindingAdapter("elapsedTime")
fun bindElapsedTime(view: TextView, t: Int) {
    view.apply {
        val minute = t / 60
        val second = t % 60

        text = "${minute}분 ${second}초"
    }
}
