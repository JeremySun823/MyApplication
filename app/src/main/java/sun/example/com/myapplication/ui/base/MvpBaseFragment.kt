package sun.example.com.myapplication.ui.base

import android.os.Bundle
import javax.inject.Inject

/**
 * Created by sun on 2020-02-16
 */
abstract class MvpBaseFragment<V, P : BaseContract.IPresenter<V>> : BaseFragment(), BaseContract.IView {

    @Inject
    lateinit var mPresenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        initInject()
        @Suppress("UNCHECKED_CAST")
        mPresenter.attach(this as V)
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detach()
    }

}