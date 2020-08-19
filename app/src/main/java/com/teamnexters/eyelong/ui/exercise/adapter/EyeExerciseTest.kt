package com.teamnexters.eyelong.ui.exercise.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.teamnexters.eyelong.BR
import com.teamnexters.eyelong.db.entity.Exercise

class EyeExerciseTest : RecyclerView.Adapter<EyeExerciseTest.ViewHolder>() {
    var items = emptyList<Exercise>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemHabitRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class ViewHolder(private val binding: ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(exercise: Exercise) {
            binding.setVariable(BR.exercise, exercise)
        }
    }
}