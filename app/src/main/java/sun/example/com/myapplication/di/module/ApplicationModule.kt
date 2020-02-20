package sun.example.com.myapplication.di.module

import android.app.Application
import dagger.Module
import dagger.Provides
import sun.example.com.myapplication.MainApplication
import sun.example.com.myapplication.di.scope.PerApplication
import javax.inject.Singleton

/**
 * Created by sun on 2020-02-16
 */
@Module
class ApplicationModule(private val app: MainApplication) {

    @Provides
    @Singleton
    @PerApplication
    fun provideApplication() : Application {
        return app
    }


}