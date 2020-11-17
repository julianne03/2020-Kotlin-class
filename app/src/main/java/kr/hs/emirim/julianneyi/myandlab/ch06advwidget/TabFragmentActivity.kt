package kr.hs.emirim.julianneyi.myandlab.ch06advwidget

import android.app.Fragment
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.FragmentTransaction
import kr.hs.emirim.julianneyi.myandlab.R

@Suppress("DEPRECATION")
class TabFragmentActivity : AppCompatActivity(), ActionBar.TabListener {

    lateinit var tabSong : ActionBar.Tab
    lateinit var tabArtist : ActionBar.Tab
    lateinit var tabAlbum : ActionBar.Tab

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_fragment)

        var bar = this.supportActionBar
        bar!!.navigationMode = ActionBar.NAVIGATION_MODE_TABS

        tabSong = bar.newTab()
        tabSong.text = "음악별"
        tabSong.setTabListener(this)
        bar.addTab(tabSong)

        tabArtist = bar.newTab()
        tabArtist.text = "가수별"
        tabArtist.setTabListener(this)
        bar.addTab(tabArtist)

        tabAlbum = bar.newTab()
        tabAlbum.text = "앨범별"
        tabAlbum.setTabListener(this)
        bar.addTab(tabAlbum)

    }

    override fun onTabSelected(tab: ActionBar.Tab?, ft: FragmentTransaction?) {
        TODO("Not yet implemented")
    }

    override fun onTabUnselected(tab: ActionBar.Tab?, ft: FragmentTransaction?) {
        TODO("Not yet implemented")
    }

    override fun onTabReselected(tab: ActionBar.Tab?, ft: FragmentTransaction?) {
        TODO("Not yet implemented")
    }

    class MyTabFragment : Fragment() {
        var tabName : String? = null
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            val data = arguments
            tabName = data!!.getString("tabName")
        }

        override fun onCreateView(
            inflater: LayoutInflater?,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            var params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT)
            var baseLayout = LinearLayout(super.getActivity())
            baseLayout.orientation = LinearLayout.VERTICAL
            baseLayout.layoutParams = params

            when(tabName) {
                "음악별" -> baseLayout.setBackgroundColor(Color.RED)
                "가수별" -> baseLayout.setBackgroundColor(Color.GREEN)
                "앨범별" -> baseLayout.setBackgroundColor(Color.BLUE)
            }
            return baseLayout

            return super.onCreateView(inflater, container, savedInstanceState)
        }
    }
}