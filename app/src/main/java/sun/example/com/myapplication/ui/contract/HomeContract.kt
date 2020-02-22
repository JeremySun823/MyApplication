package sun.example.com.myapplication.ui.contract

import sun.example.com.myapplication.bean.wallpaper.WallpaperInfo

/**
 * Created by sun on 2020-02-16
 */
class HomeContract {
    interface IPresenter {
        fun loadWallpaperInfo()
    }

    interface IView {
        fun onWallpaperInfoLoad(info: WallpaperInfo)
    }
}