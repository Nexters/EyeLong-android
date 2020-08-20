package com.teamnexters.eyelong.ui.exercise.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.teamnexters.eyelong.BR
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.databinding.ItemExerciseListBinding
import com.teamnexters.eyelong.db.entity.Exercise
import com.teamnexters.eyelong.db.entity.Habit

class EyeExerciseTest : RecyclerView.Adapter<EyeExerciseTest.ViewHolder>() {
    var items = emptyList<Exercise>()
    var observer: Observer? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemExerciseListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class ViewHolder(private val binding: ItemExerciseListBinding ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(exercise: Exercise) {

            binding.setVariable(BR.exercise, exercise)


        }
    }

    interface Observer {
        fun onItemChecked(exercise: Exercise)
        fun onItemRemoved(exercise: Exercise)
    }
}