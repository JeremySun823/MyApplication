package sun.example.com.myapplication.di.module

import dagger.Module
import dagger.Provides
import sun.example.com.myapplication.ui.contract.MainContract
import sun.example.com.myapplication.ui.presenter.MainPresenter

/**
 * Created by sun on 2020-02-16
 */
@Module
class ActivityModule {

    @Provides
    fun provideMainPresenter(): MainContract.IPresenter {
        return MainPresenter()
    }
}