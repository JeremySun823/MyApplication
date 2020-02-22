package sun.example.com.myapplication.manager

import io.reactivex.Observable
import sun.example.com.myapplication.bean.wallpaper.WallpaperInfo
import sun.example.com.myapplication.net.apis.WallpaperApis
import sun.example.com.myapplication.net.utils.BaseTransformer
import sun.example.com.myapplication.utils.ComponentUtils
import javax.inject.Inject

/**
 * Created by sun on 2020-02-21
 */
class WallpaperManager private constructor() {

    private object SingletonHolder {
        val holder = WallpaperManager()
    }

    companion object {
        val instance = SingletonHolder.holder
    }

    @Inject
    lateinit var wallpaperApis: WallpaperApis

    init {
        ComponentUtils.getApiComponent().inject(this)
    }

    fun getWallpapers(): Observable<WallpaperInfo> {
        return wallpaperApis.getWallpapers().compose(BaseTransformer())
    }

}