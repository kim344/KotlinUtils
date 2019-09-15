package com.kim344.kotlinutils.recycler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.kim344.kotlinutils.R
import kotlinx.android.synthetic.main.activity_recycler.*

class RecyclerActivity : AppCompatActivity() {

    var mVerticalDogList: ArrayList<RecyclerVerticalModel> = ArrayList()
    var mHorizontalDogList: ArrayList<RecyclerHorizontalModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        for (i in 0..2) {
            mVerticalDogList.add(RecyclerVerticalModel(R.drawable.dog00, "갈색이", 5, "수컷"))
            mVerticalDogList.add(RecyclerVerticalModel(R.drawable.dog01, "회색이", 10, "암컷"))
            mVerticalDogList.add(RecyclerVerticalModel(R.drawable.dog02, "흰둥이", 8, "수컷"))
            mVerticalDogList.add(RecyclerVerticalModel(R.drawable.dog03, "분홍이", 11, "수컷"))
            mVerticalDogList.add(RecyclerVerticalModel(R.drawable.dog04, "두더지", 3, "암컷"))
            mVerticalDogList.add(RecyclerVerticalModel(R.drawable.dog05, "누렁이", 1, "수컷"))
        }


        //세로 Recycler Setting
        recycler_vertical?.adapter = RecyclerVerticalAdapter(
            this@RecyclerActivity,
            mVerticalDogList,
            R.layout.recycler_vertical_item
        )
        recycler_vertical?.layoutManager = LinearLayoutManager(this@RecyclerActivity)
        recycler_vertical?.itemAnimator = DefaultItemAnimator()

        for (i in 0..2) {
            mHorizontalDogList.add(RecyclerHorizontalModel(R.drawable.dog00, "갈색이",5))
            mHorizontalDogList.add(RecyclerHorizontalModel(R.drawable.dog01, "회색이",10))
            mHorizontalDogList.add(RecyclerHorizontalModel(R.drawable.dog02, "흰둥이",8))
            mHorizontalDogList.add(RecyclerHorizontalModel(R.drawable.dog03, "분홍이",11))
            mHorizontalDogList.add(RecyclerHorizontalModel(R.drawable.dog04, "두더지",3))
            mHorizontalDogList.add(RecyclerHorizontalModel(R.drawable.dog05, "누렁이",1))
        }


        //가로 Recycler Setting
        recycler_horizontal?.adapter = RecyclerHorizontalAdapter(
            this@RecyclerActivity,
            mHorizontalDogList,
            R.layout.recycler_horizontal_item
        )
        recycler_horizontal?.layoutManager = LinearLayoutManager(
            this@RecyclerActivity,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        recycler_horizontal?.itemAnimator = DefaultItemAnimator()
    }
}