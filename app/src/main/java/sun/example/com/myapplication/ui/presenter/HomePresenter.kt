package sun.example.com.myapplication.ui.presenter

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import sun.example.com.myapplication.manager.WallpaperManager
import sun.example.com.myapplication.net.utils.ExceptionUtils
import sun.example.com.myapplication.ui.base.MvpBasePresenter
import sun.example.com.myapplication.ui.contract.HomeContract
import sun.example.com.myapplication.ui.fragment.HomeFragment
import sun.example.com.myapplication.utils.LogUtils
import javax.inject.Inject

/**
 * Created by sun on 2020-02-16
 */
class HomePresenter @Inject constructor() : MvpBasePresenter<HomeFragment>(), HomeContract.IPresenter {

    override fun loadWallpaperInfo() {
        LogUtils.d<HomePresenter>("loadWallpaperInfo")

        val disposable = WallpaperManager.instance.getWallpapers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    getView()?.onWallpaperInfoLoad(it)
                }, {
                    val exception = ExceptionUtils.transformThrowable(it)
                    LogUtils.d<HomePresenter>("onError exception = $exception")
                })
        subscribe(disposable)
    }

}