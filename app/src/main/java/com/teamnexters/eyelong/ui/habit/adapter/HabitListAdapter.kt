package com.teamnexters.eyelong.ui.habit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.teamnexters.eyelong.BR
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.databinding.ItemHabitRecyclerBinding
import com.teamnexters.eyelong.db.entity.Habit
import com.teamnexters.eyelong.ui.habit.viewmodel.getRegistered

class HabitListAdapter(val itemType: ItemType) :
    ListAdapter<Habit, HabitListAdapter.ViewHolder>(DiffCallback) {
    enum class ItemType { CHECKOUT, EDIT }

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

        init {
            binding.apply {
                when (itemType) {
                    ItemType.CHECKOUT -> {
                        btnHabitEdit.visibility = View.GONE
                        cbHabitCheckout.visibility = View.VISIBLE
                        cbHabitCheckout.setOnCheckedChangeListener { _, isChecked ->
                            observer?.run {
                                getItem(adapterPosition).let {
                                    if (isChecked) {
                                        onItemAdded(it)
                                    } else {
                                        onItemDeleted(it)
                                    }
                                }
                            }

                            setItemViewDrawable(isChecked)
                        }
                    }
                    ItemType.EDIT -> {
                        cbHabitCheckout.visibility = View.GONE
                        btnHabitEdit.visibility = View.VISIBLE
                        btnHabitEdit.setOnClickListener {
                            observer?.run {
                                getItem(adapterPosition).let {
                                    if (!it.getRegistered()) {
                                        onItemAdded(it)
                                    } else {
                                        onItemDeleted(it)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        fun bind(habit: Habit) {
            binding.apply {
                if (itemType == ItemType.EDIT) {
                    setItemViewDrawable(habit.getRegistered())
                }

                setVariable(BR.habit, habit)
            }
        }

        private fun setItemViewDrawable(value: Boolean) {
            var itemBackground: Int
            var iconBackground: Int
            var btnBackground: Int

            if (value) {
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
                btnHabitEdit.background = root.context.getDrawable(btnBackground)
            }
        }
    }

    interface Observer {
        fun onItemAdded(habit: Habit)
        fun onItemDeleted(habit: Habit)
    }
}
