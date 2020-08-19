package com.teamnexters.eyelong.ui.habit.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.teamnexters.eyelong.BR
import com.teamnexters.eyelong.databinding.ItemHabitEditRecyclerBinding
import com.teamnexters.eyelong.db.entity.Habit

class HabitEditRecyclerViewAdapter : RecyclerView.Adapter<HabitEditRecyclerViewAdapter.ViewHolder>() {
    var items = emptyList<Habit>()
    var observer: Observer? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemHabitEditRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class ViewHolder(private val binding: ItemHabitEditRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(habit: Habit) {
            binding.apply {
                setVariable(BR.habit, habit)
            }
        }
    }

    interface Observer {
        fun onItemChecked(habit: Habit)
        fun onItemRemoved(habit: Habit)
    }
}