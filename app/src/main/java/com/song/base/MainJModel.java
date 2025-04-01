package com.song.base;

import com.tools.base.util.L;

public class MainJModel implements MainJContract.IMainModel{
    @Override
    public boolean doSomeThing() {
        L.e("model doSomeThings");
        return true;
    }
}
