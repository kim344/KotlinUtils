package com.kim344.kotlinutils.recycler

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kim344.kotlinutils.R
import kotlinx.android.synthetic.main.activity_recycler_detail.*

class RecyclerDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_detail)

        val intent = intent

        val position = intent.getIntExtra("position", 0)
        val image = intent.getIntExtra("img", 0)
        val name = intent.getStringExtra("name")
        val age = intent.getIntExtra("age", 0)
        val gender = intent.getStringExtra("gender")

        img_detail_dog.setImageResource(image)
        txt_detail_dog_name.text = name
        txt_detail_dog_age.text = age.toString()+"살"
        txt_detail_dog_gender.text = gender
        Toast.makeText(this@RecyclerDetailActivity, position.toString() + "번째", Toast.LENGTH_SHORT).show()
    }
}