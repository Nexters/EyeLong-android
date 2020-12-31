package com.teamnexters.eyelong.ui.exercise.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.RecyclerView
import com.teamnexters.eyelong.BR
import com.teamnexters.eyelong.databinding.ItemEyeExerciseEditRecyclerBinding
import com.teamnexters.eyelong.db.entity.Exercise
import com.teamnexters.eyelong.ui.exercise.viewmodel.getRegistered

class EyeExerciseEditRecyclerViewAdapter :
    RecyclerView.Adapter<EyeExerciseEditRecyclerViewAdapter.ViewHolder>() {
    var items = ObservableArrayList<Exercise>()
    var observer: Observer? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemEyeExerciseEditRecyclerBinding.inflate(
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

    inner class ViewHolder(private val binding: ItemEyeExerciseEditRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(exercise: Exercise) {
            binding.apply {
                cbExerciseEdit.isChecked = exercise.getRegistered()
                cbExerciseEdit.setOnCheckedChangeListener { _, isChecked ->
                    observer?.run {
                        items[adapterPosition].let {
                            if (isChecked) {
                                onItemAdded(it)
                            } else {
                                onItemDeleted(it)
                            }
                        }
                    }
                }

                setVariable(BR.exercise, exercise)
            }
        }
    }

    interface Observer {
        fun onItemAdded(exercise: Exercise)
        fun onItemDeleted(exercise: Exercise)
    }
}