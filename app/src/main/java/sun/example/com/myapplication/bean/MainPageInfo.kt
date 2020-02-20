package sun.example.com.myapplication.bean

import sun.example.com.myapplication.ui.base.BaseFragment
import sun.example.com.myapplication.ui.view.TabView

/**
 * Created by sun on 2020-02-19
 */
data class MainPageInfo(
        val page: MainPage,
        val tabView: TabView,
        val fragment: BaseFragment)

enum class MainPage(val position: Int) {
    HOME(0),
    FAVORITE(1),
    NOTE(2),
    USER(3)
}
