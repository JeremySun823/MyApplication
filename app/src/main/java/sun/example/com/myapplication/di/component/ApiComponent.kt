package sun.example.com.myapplication.di.component

import dagger.Component
import sun.example.com.myapplication.di.module.ApiModule
import sun.example.com.myapplication.di.scope.Apis
import sun.example.com.myapplication.manager.WallpaperManager
import sun.example.com.myapplication.net.apis.WallpaperApis

/**
 * Created by sun on 2020-02-21
 */
@Component(modules = [ApiModule::class])
@Apis
interface ApiComponent {
    fun testApis(): WallpaperApis

    fun inject(manager: WallpaperManager)
}