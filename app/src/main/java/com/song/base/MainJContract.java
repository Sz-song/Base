package com.song.base;

import com.tools.base.BaseView;

public interface MainJContract {
    interface IMainModel {
        boolean doSomeThing();
    }

    interface IMainView extends BaseView {
        void doSomeThingSuccess();
    }

    interface IMainPresenter {
        void doSomeThing();
    }

}
