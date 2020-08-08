package com.teamnexters.eyelong.ui.exercise.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.db.entity.Exercise
import com.teamnexters.eyelong.ui.exercise.EyeExerciseDetailActivity
import kotlinx.coroutines.withContext


class EyeExerciseRecyclerViewAdapter(val ctx: Context, val dataList: ArrayList<Exercise>) :
    RecyclerView.Adapter<EyeExerciseRecyclerViewAdapter.Holder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): Holder {
        val view: View = LayoutInflater.from(ctx).inflate(R.layout.item_exercise_list, viewGroup, false)
        return Holder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {

        // profile 이미지
        if(dataList[position].tipImagePath == "")
            Glide.with(ctx).load(R.drawable.ic_launcher_background).into(holder.exercise_img)
        else
        {
            Glide.with(ctx).load(dataList[position].tipImagePath).into(holder.exercise_img)
        }

        var number = position + 1;
        holder.number.text = number.toString()
        holder.exercise_time.text = dataList[position].elapsedTime
        holder.exercise_effect.text = dataList[position].effectSimple
        holder.exercise_title.text = dataList[position].name

        //+ 나타내는 뷰 찍기
        if(itemCount < 3) {

        }

        holder.container.setOnClickListener {
            var intent = Intent(ctx, EyeExerciseDetailActivity::class.java)
            intent.putExtra("id", dataList[position].id)
            ctx.startActivity(intent)
        }
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var container : ConstraintLayout = itemView.findViewById(R.id.cl_container_box) as ConstraintLayout
        var number = itemView.findViewById(R.id.tv_number) as TextView
        var exercise_title = itemView.findViewById(R.id.tv_exercise_title) as TextView
        var exercise_effect = itemView.findViewById(R.id.tv_exercise_effect) as TextView
        var exercise_time = itemView.findViewById(R.id.tv_exercise_time) as TextView
        var exercise_img = itemView.findViewById(R.id.img_exercise) as ImageView
    }
}