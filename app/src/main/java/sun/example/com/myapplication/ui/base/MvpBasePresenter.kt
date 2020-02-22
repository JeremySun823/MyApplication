package sun.example.com.myapplication.ui.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import java.lang.ref.WeakReference

/**
 * Created by sun on 2020-02-16
 */
abstract class MvpBasePresenter<V: BaseContract.IView> : BaseContract.IPresenter<V> {

    private val subscriptions = CompositeDisposable()
    private var viewRef: WeakReference<V>? = null

    override fun attach(view: V) {
        viewRef = WeakReference(view)
    }

    override fun detach() {
        viewRef?.clear()
    }

    override fun getView(): V? {
        return viewRef?.get()
    }

    override fun subscribe(d: Disposable) {
        subscriptions.add(d)
    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

}