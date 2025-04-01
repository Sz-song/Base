package com.song.base

import com.tools.base.BasePresenter
import com.tools.base.util.L

class MainPresenter : BasePresenter<MainContract.IMainView>(),MainContract.IMainPresenter{
    private val model: MainContract.IMainModel = MainModel()


    override fun doSomeThing() {
        L.e("presenter doSomeThing")
        val doSomeThing = model.doSomeThing()
        if(doSomeThing){
            view?.doSomeThingSuccess()
        }
    }

}