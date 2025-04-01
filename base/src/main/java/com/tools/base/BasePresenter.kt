package com.tools.base


open class BasePresenter<out BaseView> {

    protected   var view : @UnsafeVariance BaseView? =null

    fun  attachView(v: @UnsafeVariance BaseView) {
        this.view = v
    }

    fun detachView() {
        if(view!=null) {
            view = null
        }
    }
}