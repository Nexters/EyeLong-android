package com.teamnexters.eyelong.ui.habit.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.RecyclerView
import com.teamnexters.eyelong.BR
import com.teamnexters.eyelong.databinding.ItemHabitAnalyticsAchieveBinding
import com.teamnexters.eyelong.db.entity.Habit

class HabitSuggestViewAdapter : RecyclerView.Adapter<HabitSuggestViewAdapter.ViewHolder>() {
    var items = ObservableArrayList<Habit>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemHabitAnalyticsAchieveBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    inner class ViewHolder(private val binding: ItemHabitAnalyticsAchieveBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(habit: Habit) {
            binding.apply {
                tvHabitBadge.text = "${items.indexOf(habit) + 1}"
                setVariable(BR.habit, habit)
            }
        }
    }
}