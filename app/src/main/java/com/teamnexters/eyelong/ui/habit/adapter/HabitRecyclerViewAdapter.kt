package com.teamnexters.eyelong.ui.habit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.teamnexters.eyelong.BR
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.databinding.ItemHabitRecyclerBinding
import com.teamnexters.eyelong.db.entity.Habit
import com.teamnexters.eyelong.ui.habit.viewmodel.getRegistered

class HabitRecyclerViewAdapter(val itemType: ItemType) :
    RecyclerView.Adapter<HabitRecyclerViewAdapter.ViewHolder>() {

    enum class ItemType {
        CHECKOUT, EDIT
    }

    var items = emptyList<Habit>()
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

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class ViewHolder(private val binding: ItemHabitRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(habit: Habit) {
            binding.apply {
                setVariable(BR.habit, habit)

                when (itemType) {
                    ItemType.CHECKOUT -> {
                        btnHabitEdit.visibility = View.GONE
                        cbHabitCheckout.visibility = View.VISIBLE
                        cbHabitCheckout.setOnCheckedChangeListener { _, isChecked ->
                            observer?.run {
                                if (isChecked) {
                                    onItemChecked(habit)
                                } else {
                                    onItemDeleted(habit)
                                }

                                setItemViewDrawable(isChecked)
                            }
                        }
                    }

                    ItemType.EDIT -> {
                        cbHabitCheckout.visibility = View.GONE
                        btnHabitEdit.visibility = View.VISIBLE
                        btnHabitEdit.setOnClickListener {
                            observer?.run {
                                if (habit.getRegistered()) {
                                    onItemDeleted(habit)
                                } else {
                                    onItemRegistered(habit)
                                }
                            }
                        }

                        setItemViewDrawable(habit.getRegistered())
                    }
                }
            }
        }

        private fun setItemViewDrawable(selected: Boolean) {
            var itemBackground: Int
            var iconBackground: Int
            var btnBackground: Int

            if (selected) {
                itemBackground = R.drawable.bg_habit_recycler_item_selected
                iconBackground = R.drawable.bg_habit_icon_selected
                btnBackground = R.drawable.ic_habit_delete
            } else {
                itemBackground = R.drawable.bg_habit_recycler_item
                iconBackground = R.drawable.bg_habit_icon
                btnBackground = R.drawable.ic_habit_add
            }

            with(binding) {
                layoutHabitItem.background = root.context.getDrawable(itemBackground)
                imgHabitIcon.background = root.context.getDrawable(iconBackground)

                if (btnHabitEdit.visibility == View.VISIBLE) {
                    btnHabitEdit.background = root.context.getDrawable(btnBackground)
                }
            }
        }
    }

    interface Observer {
        fun onItemChecked(habit: Habit)
        fun onItemRegistered(habit: Habit)
        fun onItemDeleted(habit: Habit)
    }
}
