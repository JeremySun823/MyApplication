package sun.example.com.myapplication.ui.fragment

import sun.example.com.myapplication.R
import sun.example.com.myapplication.bean.wallpaper.WallpaperInfo
import sun.example.com.myapplication.ui.base.MvpBaseFragment
import sun.example.com.myapplication.ui.contract.HomeContract
import sun.example.com.myapplication.ui.presenter.HomePresenter
import sun.example.com.myapplication.utils.ComponentUtils
import sun.example.com.myapplication.utils.LogUtils

/**
 * Created by sun on 2020-02-16
 */
class HomeFragment : MvpBaseFragment<HomeFragment, HomePresenter>(), HomeContract.IView {


    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun initData() {
        mPresenter.loadWallpaperInfo()
    }

    override fun initViews() {
    }

    override fun initInject() {
        ComponentUtils.getFragmentComponent().inject(this)
    }

    override fun onWallpaperInfoLoad(info: WallpaperInfo) {
        LogUtils.d<HomeFragment>("onWallpaperInfoLoad info = $info")
    }

}