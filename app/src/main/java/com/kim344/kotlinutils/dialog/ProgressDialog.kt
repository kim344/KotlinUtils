package com.kim344.kotlinutils.dialog

import android.app.Activity
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.text.TextUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatDialog
import com.bumptech.glide.Glide
import com.kim344.kotlinutils.R

class ProgressDialog {

    private var progressDialog: AppCompatDialog? = null

    fun progressON(activity: Activity?, message: String) {

        if (activity == null || activity.isFinishing) {
            return
        }

        if (progressDialog != null && progressDialog!!.isShowing()) {
            progressSET(message)
        } else {
            progressDialog = AppCompatDialog(activity)
            progressDialog?.setCancelable(false)
            progressDialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            progressDialog?.setContentView(R.layout.dialog_progress)
            progressDialog?.show()
        }

        val loadingImage = progressDialog?.findViewById<ImageView>(R.id.iv_frame_loading)
        loadingImage?.post { Glide.with(activity).load(R.raw.loding).into(loadingImage) }

        val txtProgressMessage = progressDialog?.findViewById<TextView>(R.id.tv_progress_message)
        if (!TextUtils.isEmpty(message)) {
            txtProgressMessage?.text = message
        }


    }

    fun progressSET(message: String) {

        if (progressDialog == null || !progressDialog!!.isShowing()) {
            return
        }


        val txtProgressMessage = progressDialog?.findViewById<TextView>(R.id.tv_progress_message)
        if (!TextUtils.isEmpty(message)) {
            txtProgressMessage?.text = message
        }

    }

    fun progressOFF() {
        if (progressDialog != null && progressDialog!!.isShowing()) {
            progressDialog!!.dismiss()
        }
    }

}