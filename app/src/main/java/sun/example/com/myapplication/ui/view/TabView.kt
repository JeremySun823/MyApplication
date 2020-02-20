package sun.example.com.myapplication.ui.view

import android.content.Context
import android.support.annotation.DrawableRes
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import kotlinx.android.synthetic.main.view_tab.view.*
import sun.example.com.myapplication.R

/**
 * Created by sun on 2020-02-20
 */
class TabView(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : FrameLayout(context) {

    init {
        LayoutInflater.from(context).inflate(R.layout.view_tab, this)
    }

    @DrawableRes
    private var image: Int = 0

    @DrawableRes
    private var selectImage: Int = 0

    fun setImage(image: Int, selectImage: Int) {
        this.image = image
        this.selectImage = selectImage
    }

    fun setRedDot(show: Boolean) {
        view_dot.visibility = if (show) View.VISIBLE else View.GONE
    }

    override fun setSelected(selected: Boolean) {
        super.setSelected(selected)
        if (selected) {
            view_dot.visibility = View.VISIBLE
            iv_tab.setImageResource(selectImage)
        } else {
            view_dot.visibility = View.GONE
            iv_tab.setImageResource(image)
        }
    }
}