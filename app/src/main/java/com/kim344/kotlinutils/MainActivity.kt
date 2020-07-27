package com.kim344.kotlinutils

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kim344.kotlinutils.dialog.DialogActivity
import com.kim344.kotlinutils.fragment.FragmentActivity
import com.kim344.kotlinutils.permission.PermissionActivity
import com.kim344.kotlinutils.recycler.RecyclerActivity
import com.kim344.kotlinutils.retrofit2.RetrofitActivity
import com.kim344.kotlinutils.tablayout.TabLayoutActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        supportActionBar?.title = "Toolbar Sample"

        btn_fragment.setOnClickListener(this)
        btn_recycler.setOnClickListener(this)
        btn_tabLayout.setOnClickListener(this)
        btn_retrofit2.setOnClickListener(this)
        btn_permission.setOnClickListener(this)
        btn_dialog.setOnClickListener(this)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings1 -> Toast.makeText(this,"Item1",Toast.LENGTH_SHORT).show()
            R.id.action_settings2 -> Toast.makeText(this,"Item2",Toast.LENGTH_SHORT).show()
            R.id.action_settings3 -> Toast.makeText(this,"Item3",Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(view: View?) {

        when (view?.id) {

            R.id.btn_fragment -> {
                val intent = Intent(this@MainActivity, FragmentActivity::class.java)
                startActivity(intent)
            }

            R.id.btn_recycler -> {
                val intent = Intent(this@MainActivity, RecyclerActivity::class.java)
                startActivity(intent)
            }

            R.id.btn_tabLayout -> {
                val intent = Intent(this@MainActivity, TabLayoutActivity::class.java)
                startActivity(intent)
            }

            R.id.btn_retrofit2 -> {
                val intent = Intent(this@MainActivity, RetrofitActivity::class.java)
                startActivity(intent)
            }

            R.id.btn_permission -> {
                val intent = Intent(this@MainActivity, PermissionActivity::class.java)
                startActivity(intent)
            }

            R.id.btn_dialog -> {
                val intent = Intent(this@MainActivity, DialogActivity::class.java)
                startActivity(intent)
            }

        }

    }

}
