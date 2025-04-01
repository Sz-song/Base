package com.tools.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.tools.base.util.L
import java.lang.reflect.ParameterizedType


open class BaseActivity<T : ViewBinding, P : BasePresenter<BaseView>> : AppCompatActivity() , BaseView{

    protected var binding: T? = null
    protected var presenter: P? = null

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
            binding = method.invoke(null, layoutInflater) as T?
            if(binding!=null) {
                L.e(binding?.javaClass?.name)
                setContentView(binding?.root)
            }else{
                L.e("binding 未初始化")
            }
            val constructor = presenterClass.getDeclaredConstructor()
            constructor.isAccessible = true
            presenter = constructor.newInstance() as P?
            if(presenter!=null){
                presenter?.attachView(this)
                L.e(presenter?.javaClass?.name)
            }else{
                L.e("presenter 未初始化")
            }
        } catch (e: Exception) {
            L.e(e.toString())
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.detachView()

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