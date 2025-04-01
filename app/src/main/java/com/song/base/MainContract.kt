package com.song.base

import com.tools.base.BaseView

interface MainContract {

    interface IMainModel {
        fun doSomeThing(): Boolean
    }

    interface IMainView : BaseView {
        fun doSomeThingSuccess()
    }

    interface IMainPresenter {
        fun doSomeThing()
    }

}