package sun.example.com.myapplication.ui.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import sun.example.com.myapplication.bean.MainPageInfo

/**
 * Created by sun on 2020-02-20
 */
class ViewPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    private var infoList = listOf<MainPageInfo>()

    override fun getItem(position: Int): Fragment {
        return infoList[position].fragment
    }

    override fun getCount(): Int {
        return infoList.size
    }

    fun setInfo(infoList: List<MainPageInfo>) {
        this.infoList = infoList
        notifyDataSetChanged()
    }

}