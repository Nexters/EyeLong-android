package com.teamnexters.eyelong.ui.exercise.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.db.entity.Exercise
import com.teamnexters.eyelong.ui.exercise.AddEyeExerciseActivity
import com.teamnexters.eyelong.ui.exercise.EyeExerciseDetailActivity


class EyeExerciseRecyclerViewAdapter(val ctx: Context, val dataList: ArrayList<Exercise>) :
    RecyclerView.Adapter<EyeExerciseRecyclerViewAdapter.Holder>() {

    private var listener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClicked()
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): Holder {
        val view: View =
            LayoutInflater.from(ctx).inflate(R.layout.item_exercise_list, viewGroup, false)


        return Holder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {

        // profile 이미지
        if (dataList[position].tipImagePath == "")
            Glide.with(ctx).load(R.drawable.ic_launcher_background).into(holder.exercise_img)
        else
            Glide.with(ctx).load(dataList[position].tipImagePath).into(holder.exercise_img)


        var number = position + 1;
        holder.number.text = number.toString()

        var second_time = dataList[position].elapsedTime
        holder.exercise_time.text =
            (second_time / 60).toString() + "분 " + (second_time % 60).toString() + "초"

        holder.exercise_effect.text = dataList[position].effectSimple
        holder.exercise_title.text = dataList[position].name


        if (dataList[position].id == -1) {
            holder.view_container.visibility = View.GONE
            holder.btn_more.visibility = View.VISIBLE
        }

        holder.container.setOnClickListener {
            var intent = Intent(ctx, EyeExerciseDetailActivity::class.java)
            intent.putExtra("name", dataList[position].name)
            intent.putExtra("effect_simple", dataList[position].effectSimple)
            intent.putExtra("effect_des", dataList[position].effectDescription)
            intent.putExtra("time", dataList[position].elapsedTime)
            intent.putExtra("image", dataList[position].tipImagePath)

            ctx.startActivity(intent)
        }

        holder.btn_more.setOnClickListener {

            Log.v("TAGG", itemCount.toString())

            if (itemCount == 4) {
                listener?.onItemClicked()
            } else {
                var intent = Intent(ctx, AddEyeExerciseActivity::class.java)
                ctx.startActivity(intent)
            }
        }

        holder.delete_btn.setOnClickListener {
            //dataList 아이템 삭제
            dataList.removeAt(position)
            notifyDataSetChanged()
        }
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val container: ConstraintLayout =
            itemView.findViewById(R.id.cl_container_box) as ConstraintLayout
        val view_container: ConstraintLayout =
            itemView.findViewById(R.id.cl_item_view_container) as ConstraintLayout

        val number = itemView.findViewById(R.id.tv_number) as TextView
        val exercise_title = itemView.findViewById(R.id.tv_exercise_title) as TextView
        val exercise_effect = itemView.findViewById(R.id.tv_exercise_effect) as TextView
        val exercise_time = itemView.findViewById(R.id.tv_exercise_time) as TextView
        val exercise_img = itemView.findViewById(R.id.img_exercise) as ImageView

        val btn_more = itemView.findViewById(R.id.cl_container_plus_btn) as ConstraintLayout
        val delete_btn = itemView.findViewById(R.id.img_delete_btn) as ImageView
    }
}