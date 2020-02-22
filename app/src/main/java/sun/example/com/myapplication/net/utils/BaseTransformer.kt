package sun.example.com.myapplication.net.utils

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import sun.example.com.myapplication.net.bean.BaseException
import sun.example.com.myapplication.net.bean.BaseResponse

/**
 * Created by sun on 2020-02-22
 */
class BaseTransformer<T> : ObservableTransformer<BaseResponse<T>, T> {
    override fun apply(upstream: Observable<BaseResponse<T>>): ObservableSource<T> {
        return upstream.flatMap { response ->
            if (response.error_code != 0) {
                Observable.error(BaseException(response.error_code, response.result_message))
            } else {
                Observable.just(response.data)
            }
        }
    }

}