package sun.example.com.myapplication.ui.activity

import android.os.Bundle
import android.support.design.widget.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import sun.example.com.myapplication.R
import sun.example.com.myapplication.bean.MainPage
import sun.example.com.myapplication.bean.MainPageInfo
import sun.example.com.myapplication.ui.adapter.ViewPagerAdapter
import sun.example.com.myapplication.ui.base.MvpBaseActivity
import sun.example.com.myapplication.ui.contract.MainContract
import sun.example.com.myapplication.ui.presenter.MainPresenter
import sun.example.com.myapplication.utils.ComponentUtils
import sun.example.com.myapplication.utils.LogUtils
import sun.example.com.myapplication.utils.StatusBarUtils

class MainActivity : MvpBaseActivity<MainActivity, MainPresenter>(), MainContract.IView {

    private var infoList = listOf<MainPageInfo>()

    private val adapter = ViewPagerAdapter(supportFragmentManager)

    override fun initInject() {
        ComponentUtils.getActivityComponent().inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusBarUtils.setColor(this, resources.getColor(R.color.base_color_white), 0)
        StatusBarUtils.setStatusTextGray(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initData() {
        infoList = mPresenter.getMainInfo(this)
    }

    override fun initViews() {
        // tabLayout
        for (mainInfo in infoList) {
            if (mainInfo.page == MainPage.HOME) {
                tab_layout.addTab(tab_layout.newTab().setCustomView(mainInfo.tabView), true)
            } else {
                tab_layout.addTab(tab_layout.newTab().setCustomView(mainInfo.tabView), false)
            }
        }

        tab_layout.addOnTabSelectedListener(TabSelectedListener())

        // viewPager
        adapter.setInfo(infoList)
        view_pager.adapter = adapter
        view_pager.offscreenPageLimit = 3
        view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))
    }


    private inner class TabSelectedListener : TabLayout.BaseOnTabSelectedListener<TabLayout.Tab> {
        override fun onTabSelected(tab: TabLayout.Tab?) {
            LogUtils.d<MainActivity>("onTabSelected tab = ${tab?.position}")
            setCurrentItem(tab?.position)
        }

        override fun onTabUnselected(tab: TabLayout.Tab?) {
            LogUtils.d<MainActivity>("onTabUnselected")
        }

        override fun onTabReselected(tab: TabLayout.Tab?) {
            LogUtils.d<MainActivity>("onTabReselected")
        }
    }

    private fun setCurrentItem(position: Int?) {
        position?.let {
            if (it <= MainPage.USER.position && it >= MainPage.HOME.position) {
                view_pager.currentItem = it
            }
        }
    }
}