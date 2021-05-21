package com.clean.kotlinjetpack.util

import android.os.SystemClock
import android.view.View

class OnDisableTimeClickListener(onClickListener: View.OnClickListener): View.OnClickListener{
    private var onClickListener: View.OnClickListener? = null
    private val defaultInterval: Long = 2000
    private var lastTimeClicked: Long = 0
    init {
        this.onClickListener=onClickListener
    }

    override fun onClick(view: View?) {
        if (SystemClock.elapsedRealtime() - lastTimeClicked < defaultInterval) {
            return
        }
        lastTimeClicked = SystemClock.elapsedRealtime()
        onClickListener!!.onClick(view)
    }




}