package com.kim344.kotlinutils.permission

import android.Manifest
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import com.kim344.kotlinutils.R
import kotlinx.android.synthetic.main.activity_permission.*
import java.util.ArrayList

class PermissionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)

        btn_check.setOnClickListener {
            val permissionlistener = object : PermissionListener {
                override fun onPermissionGranted() {
                    Toast.makeText(this@PermissionActivity, "권한 허가", Toast.LENGTH_SHORT).show()
                }

                override fun onPermissionDenied(deniedPermissions: ArrayList<String>) {
                    Toast.makeText(this@PermissionActivity, "권한 거부\n$deniedPermissions", Toast.LENGTH_SHORT).show()
                }
            }

            TedPermission.with(this@PermissionActivity)
                .setPermissionListener(permissionlistener)
                .setRationaleMessage("OOO을 하기 위해서는 접근 권한이 필요해요")
                .setDeniedMessage("[설정] > [권한] 에서 권한을 허용할 수 있어요.")
                .setPermissions(
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                )
                .check()
        }
    }
}