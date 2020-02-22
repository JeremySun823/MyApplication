package sun.example.com.myapplication.utils

import android.util.Log
import sun.example.com.myapplication.BuildConfig

object LogUtils {
    val DEBUG = BuildConfig.DEBUG
    const val DEFAULT_TAG = "[MyApplication]"
    const val LIFECYCLE_TAG = "[MyLifeCycle]"

    inline fun <reified T> d(msg: String) {
        if (DEBUG) {
            Log.d(DEFAULT_TAG, "${T::class.simpleName} : $msg")
        }
    }

    inline fun <reified T> ld(msg: String) {
        if (DEBUG) {
            Log.d(LIFECYCLE_TAG, "${T::class.simpleName} : $msg")
        }
    }
}