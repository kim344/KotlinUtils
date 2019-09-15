package com.kim344.kotlinutils.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import com.kim344.kotlinutils.R
import kotlinx.android.synthetic.main.dialog_custom_confirm_two.*

class CustomConfirmTwoDialog(
    private val mContext: Context,
    private val mTitle: String,
    private val mContent: String,
    private val mOk: String,
    private val mCancel: String,
    private val mCallBack: ClickCallBack?
) : Dialog(mContext), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_custom_confirm_two)

        confirm_buy_ok.setOnClickListener(this)
        confirm_buy_cancel.setOnClickListener(this)

        confirm_main_tv.text = mTitle
        confirm_main_tv2.text = mContent
        confirm_buy_ok.text = mOk
        confirm_buy_cancel.text = mCancel

        setCancelable(false)   // 다이얼로그 밖 터치 불가
    }

    override fun onClick(view: View?) {
        when (view?.id) {

            R.id.confirm_buy_ok -> {
                mCallBack?.onConfirm(true)
                dismiss()
            }
            R.id.confirm_buy_cancel -> {
                mCallBack?.onConfirm(false)
                dismiss()
            }
        }
    }

    interface ClickCallBack {
        fun onConfirm(isClick: Boolean)
    }


}
