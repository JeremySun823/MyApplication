package sun.example.com.myapplication.di.component

import dagger.Component
import sun.example.com.myapplication.MainApplication
import sun.example.com.myapplication.di.module.ApplicationModule

/**
 * Created by sun on 2020-02-16
 */
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: MainApplication)
}