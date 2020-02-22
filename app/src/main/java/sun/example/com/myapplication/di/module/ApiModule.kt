package sun.example.com.myapplication.di.module

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import sun.example.com.myapplication.di.scope.Apis
import sun.example.com.myapplication.net.utils.CookieInterceptor
import sun.example.com.myapplication.net.apis.WallpaperApis
import sun.example.com.myapplication.utils.LogUtils
import sun.example.com.myapplication.utils.NetUtils
import java.util.concurrent.TimeUnit


/**
 * Created by sun on 2020-02-20
 */
@Module
class ApiModule {

    @Apis
    @Provides
    fun provideTestApis(retrofit: Retrofit): WallpaperApis {
        return retrofit.create(WallpaperApis::class.java)
    }

    @Apis
    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return createRetrofit(client, NetUtils.getBaseUrl())
    }

    @Apis
    @Provides
    fun provideClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(CookieInterceptor())
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build()
    }

    private fun createRetrofit(client: OkHttpClient, url: String): Retrofit {
        LogUtils.d<ApiModule>("createRetrofit url = $url")
        return Retrofit.Builder().baseUrl(url)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }
}