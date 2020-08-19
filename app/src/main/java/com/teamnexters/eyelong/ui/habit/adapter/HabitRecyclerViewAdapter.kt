package com.teamnexters.eyelong.ui.habit.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.teamnexters.eyelong.BR
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.databinding.ItemHabitCheckRecyclerBinding
import com.teamnexters.eyelong.db.entity.Habit

class HabitRecyclerViewAdapter : RecyclerView.Adapter<HabitRecyclerViewAdapter.ViewHolder>() {
    var items = emptyList<Habit>()
    var observer: Observer? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemHabitCheckRecyclerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )

        return ViewHolder(binding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class ViewHolder(private val binding: ItemHabitCheckRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(habit: Habit) {
            binding.apply {
                setVariable(BR.habit, habit)

                cbHabit.setOnCheckedChangeListener { _, isChecked ->
                    var itemBackground: Int
                    var iconBackground: Int

                    if (isChecked) {
                        observer?.onItemChecked(habit)

                        itemBackground = R.drawable.bg_habit_recycler_item_selected
                        iconBackground = R.drawable.bg_habit_icon_selected
                    } else {
                        observer?.onItemDeleted(habit)

                        itemBackground = R.drawable.bg_habit_recycler_item
                        iconBackground = R.drawable.bg_habit_icon
                    }

                    layoutHabitItem.apply { background = context.getDrawable(itemBackground) }
                    imgHabitIcon.apply { background = context.getDrawable(iconBackground) }
                }
            }
        }
    }

    interface Observer {
        fun onItemChecked(habit: Habit)
        fun onItemDeleted(habit: Habit)
    }
}
