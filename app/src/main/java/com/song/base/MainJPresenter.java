package com.song.base;

import com.tools.base.BasePresenter;
import com.tools.base.util.L;

import java.util.Objects;

public class MainJPresenter extends BasePresenter<MainJContract.IMainView> implements MainJContract.IMainPresenter {
    private final MainJContract.IMainModel model;
    public MainJPresenter() {
        model=new MainJModel();
    }

    @Override
    public void doSomeThing() {
        L.e("presenter doSomeThing");
        boolean doSomeThing = model.doSomeThing();
        if(doSomeThing && getView() !=null){
            getView().doSomeThingSuccess();
        }
    }
}
