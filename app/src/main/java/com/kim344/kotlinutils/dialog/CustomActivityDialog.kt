package com.kim344.kotlinutils.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.WindowManager
import com.kim344.kotlinutils.R
import kotlinx.android.synthetic.main.dialog_custom_confirm.*

class CustomActivityDialog(
    private val mContext: Context,
    private val mTitle: String,
    private val mCallback: IConfirmCallback?
) : Dialog(mContext) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_custom_confirm)

        val displayMetrics = mContext.applicationContext.resources.displayMetrics    // 디바이스 크기

        val layoutParams = WindowManager.LayoutParams()
        layoutParams.copyFrom(window?.attributes)
        layoutParams.width = (displayMetrics.widthPixels * 0.89).toInt()     // 다이얼로그 너비 %
        layoutParams.height = (displayMetrics.heightPixels * 0.35).toInt()   // 다이얼로그 높이 %
        layoutParams.gravity = Gravity.CENTER
        this.window?.attributes = layoutParams

        setCancelable(false)   // 다이얼로그 밖 터치 불가

        dialog_confirm_msg_tv?.text = mTitle
        dialog_confirm_ly?.setOnClickListener {
            mCallback?.onConfirm()
            dismiss()
        }
    }

    interface IConfirmCallback {
        fun onConfirm()
    }

}
