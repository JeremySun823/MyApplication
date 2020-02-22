package sun.example.com.myapplication.net.utils

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by sun on 2020-02-20
 */
class CookieInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        // todo, jeremy, only for test
        val originRequest = chain.request()
        val token = "cn01:3ca6570f-7fbc-417b-8211-ebc033b9fed0"
        val request = originRequest.newBuilder()
                .addHeader("Cookie", "auth_token=$token") // 添加token
                .build()
        return chain.proceed(request)
    }

}