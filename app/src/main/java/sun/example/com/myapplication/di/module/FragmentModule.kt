package sun.example.com.myapplication.di.module

import dagger.Module
import dagger.Provides
import sun.example.com.myapplication.ui.contract.HomeContract
import sun.example.com.myapplication.ui.presenter.HomePresenter

/**
 * Created by sun on 2020-02-16
 */
@Module
class FragmentModule {

    @Provides
    fun provideHomePresenter(): HomeContract.IPresenter {
        return HomePresenter()
    }
}