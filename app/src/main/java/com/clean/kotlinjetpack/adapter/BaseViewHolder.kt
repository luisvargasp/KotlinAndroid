package com.clean.kotlinjetpack.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.clean.kotlinjetpack.Product

abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun onBind(item: Product?)
}