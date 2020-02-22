package sun.example.com.myapplication.net.utils

import retrofit2.HttpException
import sun.example.com.myapplication.net.bean.BaseException
import sun.example.com.myapplication.utils.LogUtils

/**
 * Created by sun on 2020-02-22
 */
object ExceptionUtils {

    fun transformThrowable(throwable: Throwable): BaseException {
        LogUtils.d<ExceptionUtils>("transformThrowable throwable = $throwable")
        return when (throwable) {
            is HttpException -> BaseException(throwable.code(), throwable.message())
            is BaseException -> throwable
            else -> BaseException(0, throwable.message)
        }
    }

}