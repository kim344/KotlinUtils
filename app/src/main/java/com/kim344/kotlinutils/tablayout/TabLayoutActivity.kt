package com.kim344.kotlinutils.tablayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import com.kim344.kotlinutils.R
import kotlinx.android.synthetic.main.activity_tablayout.*

class TabLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tablayout)

        // 뷰페이저 연결 ( Main_Pager_Adapter 와 연결 )
        val pagerAdapter = ContentsPagerAdapter(supportFragmentManager)
        pager_content.adapter = pagerAdapter

        layout_tab.addTab(layout_tab.newTab().setText("Book"))
        layout_tab.addTab(layout_tab.newTab().setText("Game"))
        layout_tab.addTab(layout_tab.newTab().setText("Home"))
        layout_tab.addTab(layout_tab.newTab().setText("Movie"))
        layout_tab.addTab(layout_tab.newTab().setText("News"))

        pager_content.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(layout_tab))
        layout_tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.position?.let { pager_content.currentItem = it }
            }

        })
    }
}