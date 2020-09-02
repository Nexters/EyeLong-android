package com.teamnexters.eyelong.ui.habit.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.RecyclerView
import com.teamnexters.eyelong.BR
import com.teamnexters.eyelong.databinding.ItemHabitAnalyticsChartBinding
import com.teamnexters.eyelong.ui.habit.chart.Item
import kotlin.math.roundToInt

class HabitChartViewAdapter : RecyclerView.Adapter<HabitChartViewAdapter.ViewHolder>() {
    var items = ObservableArrayList<Item>()

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
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    inner class ViewHolder(private val binding: ItemHabitAnalyticsChartBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Item) {
            binding.apply {
                root.post {
                    viewItemChartAchieved.apply {
                        layoutParams.apply {
                            height =
                                item.value * (viewItemChartBackground.height.toDouble() / 5).roundToInt()
                        }.also {
                            layoutParams = it
                        }
                    }
                }

                setVariable(BR.item, item)
            }
        }
    }
}