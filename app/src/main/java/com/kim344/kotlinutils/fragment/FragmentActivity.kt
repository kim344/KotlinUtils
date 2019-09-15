package com.kim344.kotlinutils.fragment

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.kim344.kotlinutils.R
import kotlinx.android.synthetic.main.activity_fragment.*

class FragmentActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        // 초기값
        setFrag(0)

        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
    }

    private fun setFrag(page: Int) {

        when (page) {

            0 -> supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_frame, FragmentPage1())
                .commit()
            1 -> supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_frame, FragmentPage2())
                .commit()
            2 -> supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_frame, FragmentPage3())
                .commit()
        }

    }

    override fun onClick(view: View?) {

        when (view?.id) {

            R.id.btn1 -> {
                setFrag(0)
            }

            R.id.btn2 -> {
                setFrag(1)
            }

            R.id.btn3 -> {
                setFrag(2)
            }

        }

    }

}