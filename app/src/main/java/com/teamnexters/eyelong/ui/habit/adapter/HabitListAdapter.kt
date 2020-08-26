package com.teamnexters.eyelong.ui.habit.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.teamnexters.eyelong.BR
import com.teamnexters.eyelong.databinding.ItemHabitRecyclerBinding
import com.teamnexters.eyelong.db.entity.Habit

class HabitListAdapter : ListAdapter<Habit, HabitListAdapter.ViewHolder>(DiffCallback) {
    var observer: Observer? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemHabitRecyclerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemHabitRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(habit: Habit) {
            binding.apply {
                setVariable(BR.habit, habit)
            }
        }
    }

    interface Observer {
        fun onItemAdded(habit: Habit)
        fun onItemDeleted(habit: Habit)
    }
}
