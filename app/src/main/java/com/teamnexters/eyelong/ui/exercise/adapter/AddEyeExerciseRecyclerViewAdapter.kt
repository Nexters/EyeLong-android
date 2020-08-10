package com.teamnexters.eyelong.ui.exercise.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.db.entity.Exercise

class AddEyeExerciseRecyclerViewAdapter(val ctx: Context) :
    RecyclerView.Adapter<AddEyeExerciseRecyclerViewAdapter.Holder>() {

    private var dataList = emptyList<Exercise>()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): Holder {
        val view: View =
            LayoutInflater.from(ctx).inflate(R.layout.item_eye_exercise_list_edit, viewGroup, false)

        return Holder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {

        var img_checked = 0

        // profile 이미지
        if (dataList[position].tipImagePath == "")
            Glide.with(ctx).load(R.drawable.ic_launcher_background).into(holder.exercise_img)
        else {
            Glide.with(ctx).load(dataList[position].tipImagePath).into(holder.exercise_img)
        }

        holder.check_btn.setOnClickListener {
            if (img_checked == 0) {
                holder.check_btn.isSelected = true
                img_checked = 1
            } else {
                holder.check_btn.isSelected = false
                img_checked = 0
            }
        }

        var second_time = dataList[position].elapsedTime
        holder.exercise_time.text =
            (second_time / 60).toString() + "분 " + (second_time % 60).toString() + "초"
        holder.exercise_effect.text = dataList[position].effectSimple
        holder.exercise_title.text = dataList[position].name
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val check_btn = itemView.findViewById(R.id.img_check_btn_rv_item) as ImageView

        val exercise_title = itemView.findViewById(R.id.tv_exercise_title) as TextView
        val exercise_effect = itemView.findViewById(R.id.tv_exercise_effect) as TextView
        val exercise_time = itemView.findViewById(R.id.tv_start_eye_exercise) as TextView

        val exercise_img = itemView.findViewById(R.id.img_exercise) as ImageView

    }

    internal fun setWords(exercise: List<Exercise>) {
        this.dataList = exercise
        notifyDataSetChanged()
    }
}