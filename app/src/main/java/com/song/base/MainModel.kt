package com.song.base

import com.tools.base.util.L

class MainModel :MainContract.IMainModel{
    override fun doSomeThing(): Boolean {
        L.e("model doSomeThings")
        return true
    }
}