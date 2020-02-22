package sun.example.com.myapplication.bean.wallpaper

import com.google.gson.annotations.SerializedName

/**
 * Created by sun on 2020-02-22
 */
data class WallpaperInfo(
        @SerializedName("version")
        val version: String,
        @SerializedName("wallpapers")
        val wallpapers: List<Wallpaper>)