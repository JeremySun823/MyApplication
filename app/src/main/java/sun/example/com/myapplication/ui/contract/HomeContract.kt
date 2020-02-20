package sun.example.com.myapplication.ui.contract

/**
 * Created by sun on 2020-02-16
 */
class HomeContract {
    interface IPresenter {
        fun loadHomeInfo()
    }

    interface IView {
        fun onHomeInfoLoad()
    }
}