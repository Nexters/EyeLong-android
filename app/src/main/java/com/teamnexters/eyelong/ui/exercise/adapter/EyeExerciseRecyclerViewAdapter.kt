package com.teamnexters.eyelong.ui.exercise.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.RecyclerView
import com.teamnexters.eyelong.BR
import com.teamnexters.eyelong.databinding.FooterEyeExerciseRecyclerBinding
import com.teamnexters.eyelong.databinding.ItemEyeExerciseRecyclerBinding
import com.teamnexters.eyelong.db.entity.Exercise

class EyeExerciseRecyclerViewAdapter :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val VIEW_TYPE_HEADER = 0
    private val VIEW_TYPE_ITEM = 1
    private val VIEW_TYPE_FOOTER = 2

    var items = ObservableArrayList<Exercise>()
    var observer: Observer? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_FOOTER -> {
                val binding =
                    FooterEyeExerciseRecyclerBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )

                FooterViewHolder(binding)
            }
            else -> {
                val binding =
                    ItemEyeExerciseRecyclerBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )

                ItemViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemViewHolder) {
            holder.bind(items[position])
        }
    }

    override fun getItemCount() = items.size + 1

    override fun getItemViewType(position: Int) =
        if (position == items.size) VIEW_TYPE_FOOTER else VIEW_TYPE_ITEM

    inner class ItemViewHolder(private val binding: ItemEyeExerciseRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.apply {
                root.setOnClickListener {
                    observer?.onItemClick(items[adapterPosition])
                }

                btnExerciseDelete.setOnClickListener {
                    observer?.onItemDeleted(items[adapterPosition])
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

    inner class FooterViewHolder(private val binding: FooterEyeExerciseRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.apply {
                btnExerciseAdd.setOnClickListener {}
            }
        }
    }

    interface Observer {
        fun onItemClick(exercise: Exercise)
        fun onItemAdded(exercise: Exercise)
        fun onItemDeleted(exercise: Exercise)
        fun onExerciseAddButtonClick()
    }
}