package com.example.simpleblog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.drawerlayout.widget.DrawerLayout
import com.example.simpleblog.model.AddTodo
import com.example.simpleblog.model.Data2
import com.example.simpleblog.model.Product
import com.example.simpleblog.model.Todo
import com.example.simpleblog.network.RetrofitHelper.Companion.getRetrofit
import com.example.simpleblog.network.TodoService
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.adddialoglayout.*
import kotlinx.android.synthetic.main.app_bar_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.widget.EditText



class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        return false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        val simpleFragmentPagerAdapter = SimpleFragmentPagerAdapter(supportFragmentManager)
        //val viewPager: ViewPager = findViewById(R.id.view_pager)
        view_pager.adapter = simpleFragmentPagerAdapter
        //val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(view_pager)
        navView.setNavigationItemSelectedListener(this)
        val gh = getRetrofit<TodoService>()

        fabAddTodo.setOnClickListener {
            val dialogBuilder = AlertDialog.Builder(this).create()
            val inflater = layoutInflater
            val dialogView = inflater.inflate(R.layout.adddialoglayout,null)
            val editText = dialogView.findViewById(R.id.et_todo) as EditText
            val button1 = dialogView.findViewById(R.id.buttonSubmit) as Button
            val button2 = dialogView.findViewById(R.id.buttonCancel) as Button
            button1.setOnClickListener {
                dialogBuilder.dismiss()
            }
            button2.setOnClickListener {

                dialogBuilder.dismiss()
            }
            dialogBuilder.setView(dialogView)
            dialogBuilder.show()
        }
    }

}
