package com.clean.kotlinjetpack.util

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

class ImageUtil {
    fun showImageFromUrl(context: Context?, url: String?, imageView: ImageView?) {
        Glide.with(context!!).load(url).into(imageView!!)
    }
}