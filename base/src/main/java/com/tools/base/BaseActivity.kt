package com.tools.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.tools.base.util.L
import java.lang.reflect.ParameterizedType


open class BaseActivity<T,P>  : AppCompatActivity() , BaseView
        where T : ViewBinding, P : BasePresenter<BaseView>{

    lateinit var binding: T
    lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind()
    }

    private fun bind() {
        try {
            val cls = javaClass.genericSuperclass as ParameterizedType
            //getActualTypeArguments取出该类的泛型
            val bindingClass = cls.actualTypeArguments[0] as Class<*>
            val presenterClass = cls.actualTypeArguments[1] as Class<*>
            //获取viewBinding的inflate方法
            val method = bindingClass.getDeclaredMethod("inflate", LayoutInflater::class.java)
            /* 执行viewBinding的inflate方法 */
            binding = method.invoke(null, layoutInflater) as T
            L.e(binding.javaClass.name)
            setContentView(binding.root)
            //初始化presenter
            val constructor = presenterClass.getDeclaredConstructor()
            constructor.isAccessible = true
            presenter = constructor.newInstance() as P
            presenter.attachView(this)
            L.e(presenter.javaClass.name)
        } catch (e: Exception) {
            L.e(e.toString())
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()

    }

    override fun showToast(msg: String?) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun showToast(msgRes: Int?) {
        Toast.makeText(this, getString(msgRes!!), Toast.LENGTH_SHORT).show()
    }

    override fun getContext(): Context {
        return this
    }
}