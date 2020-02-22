package sun.example.com.myapplication.ui.contract

import android.content.Context
import sun.example.com.myapplication.bean.MainPageInfo

/**
 * Created by sun on 2020-02-16
 */
class MainContract {
    interface IPresenter {
        fun getMainInfo(context: Context): List<MainPageInfo>
    }

    interface IView {
    }
}