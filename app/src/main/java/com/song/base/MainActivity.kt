package com.song.base

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.song.base.databinding.ActivityMainBinding
import com.tools.base.BaseActivity
import com.tools.base.util.L

class MainActivity : BaseActivity<ActivityMainBinding,MainPresenter>(),MainContract.IMainView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter?.doSomeThing()
    }

    override fun doSomeThingSuccess() {
        L.e("view doSomeThingSuccess")
        Toast.makeText(this,"doSomeThings",Toast.LENGTH_SHORT).show()
    }
}