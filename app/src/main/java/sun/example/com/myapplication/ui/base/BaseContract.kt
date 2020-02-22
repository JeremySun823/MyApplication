package sun.example.com.myapplication.ui.base

import io.reactivex.disposables.Disposable

/**
 * Created by sun on 2020-02-16
 */
class BaseContract {

    interface IPresenter<V> {
        fun attach(view: V)
        fun detach()
        fun getView(): V?
        fun subscribe(d: Disposable)
        fun unsubscribe()
    }

    interface IView {
        fun initInject()
    }
}