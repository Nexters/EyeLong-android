package com.teamnexters.eyelong.ui.habit.adapter

import androidx.recyclerview.widget.DiffUtil
import com.teamnexters.eyelong.db.entity.Habit

object DiffCallback : DiffUtil.ItemCallback<Habit>() {
    override fun areItemsTheSame(oldItem: Habit, newItem: Habit): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Habit, newItem: Habit): Boolean {
        return oldItem.id == newItem.id
    }
}