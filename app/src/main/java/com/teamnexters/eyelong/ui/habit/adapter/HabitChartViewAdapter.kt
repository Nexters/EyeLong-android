package com.teamnexters.eyelong.ui.habit.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.teamnexters.eyelong.databinding.ItemHabitAnalyticsChartBinding
import com.teamnexters.eyelong.db.entity.Habit

class HabitChartViewAdapter : RecyclerView.Adapter<HabitChartViewAdapter.ViewHolder>() {
    val items = emptyList<Habit>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemHabitAnalyticsChartBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount() = items.size

    inner class ViewHolder(private val binding: ItemHabitAnalyticsChartBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(habit: Habit) {}
    }
}