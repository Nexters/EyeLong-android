package com.teamnexters.eyelong.ui.binding

import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView

@BindingAdapter("icon")
fun bindIcon(view: ImageView, imagePath: String?) {
    view.context.run {
        val drawable = getDrawable(resources.getIdentifier(imagePath, "drawable", packageName))
        view.setImageDrawable(drawable)
    }
}

@BindingAdapter("divider")
fun bindDivider(view: RecyclerView, drawable: Drawable) {
    val layoutManager = view.layoutManager as? LinearLayoutManager
        ?: LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false).apply {
            view.layoutManager = this
        }

    layoutManager.let {
        object : DividerItemDecoration(view.context, it.orientation) {
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                if (parent.getChildAdapterPosition(view) == state.itemCount - 1) {
                    outRect.setEmpty()
                } else {
                    super.getItemOffsets(outRect, view, parent, state)
                }
            }
        }.apply {
            setDrawable(drawable)
        }.also {
            view.addItemDecoration(it)
        }
    }
}

@BindingAdapter("app:lottie_fileName")
fun bindLottieImage(view: LottieAnimationView, lottieImagePath: ObservableField<String>) {
    view.apply {
        lottieImagePath.get()?.let {
            setAnimation(it)
            playAnimation()
        }
    }
}
