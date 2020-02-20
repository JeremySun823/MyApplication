package sun.example.com.myapplication.di.component

import dagger.Component
import sun.example.com.myapplication.di.module.ActivityModule
import sun.example.com.myapplication.ui.activity.MainActivity

/**
 * Created by sun on 2020-02-16
 */
@Component(modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)
}