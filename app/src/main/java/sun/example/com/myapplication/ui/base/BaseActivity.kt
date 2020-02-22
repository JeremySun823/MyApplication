package sun.example.com.myapplication.ui.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity: AppCompatActivity() {
    var mIsForeground = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initData()
        initViews()
    }

    @LayoutRes
    abstract fun getLayoutId(): Int
    abstract fun initData()
    abstract fun initViews()

    override fun onResume() {
        super.onResume()
        mIsForeground = true
    }

    override fun onPause() {
        super.onPause()
        mIsForeground = false
    }
}