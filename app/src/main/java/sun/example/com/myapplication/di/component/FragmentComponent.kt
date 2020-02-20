package sun.example.com.myapplication.di.component

import dagger.Component
import sun.example.com.myapplication.di.module.FragmentModule
import sun.example.com.myapplication.ui.fragment.HomeFragment

/**
 * Created by sun on 2020-02-16
 */
@Component(modules = [FragmentModule::class])
interface FragmentComponent {

    fun inject(homeFragment: HomeFragment)
}
