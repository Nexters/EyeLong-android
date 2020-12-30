package com.teamnexters.eyelong.ui.exercise.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.RecyclerView
import com.teamnexters.eyelong.BR
import com.teamnexters.eyelong.databinding.ItemEyeExerciseRecyclerBinding
import com.teamnexters.eyelong.db.entity.Exercise

class EyeExerciseRecyclerViewAdapter :
    RecyclerView.Adapter<EyeExerciseRecyclerViewAdapter.ViewHolder>() {
    var items = ObservableArrayList<Exercise>()
    var observer: Observer? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemEyeExerciseRecyclerBinding.inflate(
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

    inner class ViewHolder(private val binding: ItemEyeExerciseRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.apply {
                btnExerciseDelete.setOnClickListener {
                    observer?.run { onItemDeleted(items[adapterPosition]) }
                }
            }
        }

        fun bind(exercise: Exercise) {
            binding.apply {
                tvNo.text = "${items.indexOf(exercise) + 1}"

                setVariable(BR.exercise, exercise)
            }
        }
    }

    interface Observer {
        fun onItemAdded(exercise: Exercise)
        fun onItemDeleted(exercise: Exercise)
    }
}