package com.kim344.kotlinutils.recycler

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.kim344.kotlinutils.R

class RecyclerHorizontalAdapter(
    private val mContext: Context,
    private val mDogList: ArrayList<RecyclerHorizontalModel>,
    private val mItemLayout: Int) : RecyclerView.Adapter<RecyclerHorizontalAdapter.ViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(mItemLayout, viewGroup, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mDogList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        val item = mDogList[position]
        viewHolder.dogImage?.setImageResource(item.itemDogImage)
        viewHolder.dogName?.text = "이름 : ${item.itemDogName}"

        viewHolder.itemHorizontal?.setOnClickListener {
            val intent = Intent(mContext, RecyclerDetailActivity::class.java)
            intent.putExtra("position", position)
            intent.putExtra("img", item.itemDogImage)
            intent.putExtra("name", item.itemDogName)
            intent.putExtra("age", item.itemDogAge)

            mContext.startActivity(intent)
        }
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val itemHorizontal = itemView?.findViewById<ConstraintLayout>(R.id.item_horizontal)
        val dogImage = itemView?.findViewById<ImageView>(R.id.img_horizontal_dog_image)
        val dogName = itemView?.findViewById<TextView>(R.id.txt_horizontal_dog_name)
    }
}