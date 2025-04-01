package com.song.base;


import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.song.base.databinding.ActivityMainBinding;
import com.tools.base.BaseActivity;
import com.tools.base.util.L;

public class MainJActivity extends BaseActivity<ActivityMainBinding, MainJPresenter> implements MainJContract.IMainView {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter.doSomeThing();
    }

    @Override
    public void doSomeThingSuccess() {
        L.e("view doSomeThingSuccess");
        Toast.makeText(this, "doSomeThings", Toast.LENGTH_SHORT).show();
    }
}
