package sun.example.com.myapplication.utils

import sun.example.com.myapplication.di.component.*

/**
 * Created by sun on 2020-02-16
 */
object ComponentUtils {

    fun getApplicationComponent(): ApplicationComponent {
        return DaggerApplicationComponent.builder().build()
    }

    fun getActivityComponent(): ActivityComponent {
        return DaggerActivityComponent.builder().build()
    }

    fun getFragmentComponent(): FragmentComponent {
        return DaggerFragmentComponent.builder().build()
    }
}