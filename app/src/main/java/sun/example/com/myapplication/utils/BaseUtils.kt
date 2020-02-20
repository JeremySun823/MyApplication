package sun.example.com.myapplication.utils

import android.app.ActivityManager
import android.content.Context

object BaseUtils {

    fun getProcessName(context: Context?): String? {
        val am = context?.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val runningApps = am.runningAppProcesses
        val pid = android.os.Process.myPid()
        for (processInfo in runningApps) {
            if (processInfo.pid == pid) {
                return processInfo.processName
            }
        }
        return null
    }
}