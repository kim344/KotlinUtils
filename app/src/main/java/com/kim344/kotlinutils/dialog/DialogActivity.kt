package com.kim344.kotlinutils.dialog

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.kim344.kotlinutils.R
import kotlinx.android.synthetic.main.activity_dialog.*

class DialogActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)

        btn_progress_dialog.setOnClickListener(this)
        btn_yes_no_basic_dialog.setOnClickListener(this)
        btn_confirm_basic_dialog.setOnClickListener(this)
        btn_yes_no_custom_dialog.setOnClickListener(this)
        btn_confirm_custom_dialog.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_progress_dialog -> {
                startProgress(1000,"Loading...")
            }

            R.id.btn_yes_no_basic_dialog -> {
                basicYesOrNoDialog()
            }

            R.id.btn_confirm_basic_dialog -> {
                basicConfirmDialog()
            }

            R.id.btn_yes_no_custom_dialog -> {
                customYesOrNoDialog()
            }

            R.id.btn_confirm_custom_dialog -> {
                customActivityDialog()
            }
        }
    }

    private fun startProgress(delay: Int, message: String) {
        val progressDialog = ProgressDialog()
        progressDialog.progressON(this@DialogActivity, message)
        Handler().postDelayed({ progressDialog.progressOFF() }, delay.toLong())
    }

    private fun basicYesOrNoDialog() {

        /*
        val dialogListener = DialogInterface.OnClickListener { _, which ->
            when (which) {
                DialogInterface.BUTTON_POSITIVE ->
                    Toast.makeText(
                        applicationContext,
                        "Yes 를 선택했습니다.",
                        Toast.LENGTH_LONG
                    ).show()
                DialogInterface.BUTTON_NEGATIVE ->
                    Toast.makeText(
                        applicationContext,
                        "No 를 선택했습니다.",
                        Toast.LENGTH_LONG
                    ).show()
            }
        }
        */

        val builder = AlertDialog.Builder(this)
        builder.setTitle("BasicAlertDialog Title")
        builder.setMessage("BasicAlertDialog Content")
        builder.setPositiveButton("Yes") { _, _ ->
            Toast.makeText(this@DialogActivity, "Yes 를 선택했습니다.", Toast.LENGTH_LONG).show()
        }
        builder.setNegativeButton("No") { _, _ ->
            Toast.makeText(applicationContext, "No 를 선택했습니다.", Toast.LENGTH_LONG).show()
        }
        //다이얼로그 밖 터치 막기
        builder.setCancelable(false)
        builder.show()
    }


    private fun basicConfirmDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("BasicAlertDialog Title")
        builder.setMessage("BasicAlertDialog Content")
        builder.setPositiveButton("Yes") { _, _ ->
            Toast.makeText(this@DialogActivity, "Yes 를 선택했습니다.", Toast.LENGTH_LONG).show()
        }
        //다이얼로그 밖 터치 막기
        builder.setCancelable(false)
        builder.show()
    }

    private fun customYesOrNoDialog() {
        CustomConfirmTwoDialog(this@DialogActivity,
            getString(R.string.txt_title_yes_no_custom_dialog),
            getString(R.string.txt_contents_yes_no_custom_dialog),
            "Yes", "No",
            object : CustomConfirmTwoDialog.ClickCallBack {
                override fun onConfirm(isClick: Boolean) {
                    if (isClick) {
                        Toast.makeText(this@DialogActivity, "Yes 를 선택했습니다.", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(this@DialogActivity, "No 를 선택했습니다.", Toast.LENGTH_LONG).show()
                    }
                }
            }).show()
    }

    private fun customActivityDialog() {
        CustomActivityDialog(this@DialogActivity,
            getString(R.string.txt_title_yes_no_custom_dialog),
            object : CustomActivityDialog.IConfirmCallback {
                override fun onConfirm() {
                    Toast.makeText(this@DialogActivity, "OK 를 선택했습니다.", Toast.LENGTH_LONG).show()
                }
            }).show()
    }
}