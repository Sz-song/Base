package com.tools.base

import android.content.Context

public interface BaseView {
    fun showToast(msg:String?)
    fun showToast(msgRes: Int?)
    fun getContext():Context
}