package sun.example.com.myapplication

import android.support.multidex.MultiDexApplication
import sun.example.com.myapplication.utils.BaseUtils
import sun.example.com.myapplication.utils.ComponentUtils

class MainApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        val processName = BaseUtils.getProcessName(this)
        if (processName == this.packageName) {
            initMainProcess()
        }

        initDagger()
        registerActivityLifecycleCallbacks(LifeCycleObserver)
    }

    private fun initMainProcess() {
        // todo, jeremy
    }

    private fun initDagger() {
        ComponentUtils.getApplicationComponent().inject(this)
    }

}