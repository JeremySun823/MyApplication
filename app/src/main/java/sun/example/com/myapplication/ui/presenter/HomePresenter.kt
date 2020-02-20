package sun.example.com.myapplication.ui.presenter

import sun.example.com.myapplication.ui.base.MvpBasePresenter
import sun.example.com.myapplication.ui.contract.HomeContract
import sun.example.com.myapplication.ui.fragment.HomeFragment
import sun.example.com.myapplication.utils.LogUtils
import javax.inject.Inject

/**
 * Created by sun on 2020-02-16
 */
class HomePresenter @Inject constructor() : MvpBasePresenter<HomeFragment>(), HomeContract.IPresenter {

    override fun loadHomeInfo() {
        LogUtils.d<HomePresenter>("loadHomeInfo")
        getView()?.onHomeInfoLoad()
    }

}