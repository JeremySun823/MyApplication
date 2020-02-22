package sun.example.com.myapplication

import android.app.Activity
import android.app.Application
import android.os.Bundle
import sun.example.com.myapplication.utils.BaseUtils
import sun.example.com.myapplication.utils.LogUtils

object LifeCycleObserver : Application.ActivityLifecycleCallbacks {

    override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
        LogUtils.ld<LifeCycleObserver>("onActivityCreated name = ${activity?.javaClass?.name}")
        LogUtils.ld<LifeCycleObserver>("onActivityCreated process = ${BaseUtils.getProcessName(activity?.applicationContext)}")
        LogUtils.ld<LifeCycleObserver>("onActivityCreated intent = ${activity?.intent}")
    }

    override fun onActivityPaused(activity: Activity?) {
        LogUtils.ld<LifeCycleObserver>("onActivityPaused name = ${activity?.javaClass?.name}")
    }

    override fun onActivityResumed(activity: Activity?) {
        LogUtils.ld<LifeCycleObserver>("onActivityResumed name = ${activity?.javaClass?.name}")
    }

    override fun onActivityStarted(activity: Activity?) {
        LogUtils.ld<LifeCycleObserver>("onActivityStarted name = ${activity?.javaClass?.name}")
    }

    override fun onActivityDestroyed(activity: Activity?) {
        LogUtils.ld<LifeCycleObserver>("onActivityDestroyed name = ${activity?.javaClass?.name}")
    }

    override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
        LogUtils.ld<LifeCycleObserver>("onActivitySaveInstanceState name = ${activity?.javaClass?.name}")
    }

    override fun onActivityStopped(activity: Activity?) {
        LogUtils.ld<LifeCycleObserver>("onActivityStopped name = ${activity?.javaClass?.name}")
    }

}