package sun.example.com.myapplication.ui.presenter

import android.content.Context
import sun.example.com.myapplication.R
import sun.example.com.myapplication.bean.MainPage
import sun.example.com.myapplication.bean.MainPageInfo
import sun.example.com.myapplication.ui.activity.MainActivity
import sun.example.com.myapplication.ui.base.MvpBasePresenter
import sun.example.com.myapplication.ui.contract.MainContract
import sun.example.com.myapplication.ui.fragment.FavoriteFragment
import sun.example.com.myapplication.ui.fragment.HomeFragment
import sun.example.com.myapplication.ui.fragment.NoteFragment
import sun.example.com.myapplication.ui.fragment.UserFragment
import sun.example.com.myapplication.ui.view.TabView
import javax.inject.Inject

/**
 * Created by sun on 2020-02-16
 */
class MainPresenter @Inject constructor() : MvpBasePresenter<MainActivity>(), MainContract.IPresenter {


    override fun getMainInfo(context: Context): List<MainPageInfo> {
        val homeTab = TabView(context).apply { setImage(R.drawable.ic_main_home, R.drawable.ic_main_home) }
        val favoriteTab = TabView(context).apply { setImage(R.drawable.ic_main_favorite, R.drawable.ic_main_favorite) }
        val noteTab = TabView(context).apply { setImage(R.drawable.ic_main_note, R.drawable.ic_main_note) }
        val userTab = TabView(context).apply { setImage(R.drawable.ic_main_user, R.drawable.ic_main_user) }

        val homeFragment = HomeFragment()
        val favoriteFragment = FavoriteFragment()
        val noteFragment = NoteFragment()
        val userFragment = UserFragment()

        return listOf(
                MainPageInfo(MainPage.HOME, homeTab, homeFragment),
                MainPageInfo(MainPage.FAVORITE, favoriteTab, favoriteFragment),
                MainPageInfo(MainPage.NOTE, noteTab, noteFragment),
                MainPageInfo(MainPage.USER, userTab, userFragment)
        )
    }

}