package sun.example.com.myapplication.net.apis

import io.reactivex.Observable
import retrofit2.http.GET
import sun.example.com.myapplication.bean.wallpaper.WallpaperInfo
import sun.example.com.myapplication.net.bean.BaseResponse

/**
 * Created by sun on 2020-02-21
 */
interface WallpaperApis{

    @GET("/a/mig2/wallpapers")
    fun getWallpapers(): Observable<BaseResponse<WallpaperInfo>>

}