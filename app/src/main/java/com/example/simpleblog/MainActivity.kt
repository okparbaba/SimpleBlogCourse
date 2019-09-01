package com.example.simpleblog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
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
import kotlinx.android.synthetic.main.app_bar_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

//        gh.getTodos().enqueue(object:Callback<Todo>{
//            override fun onFailure(call: Call<Todo>, t: Throwable) {
//                Log.e("todo",t.message.toString())
//            }
//
//            override fun onResponse(call: Call<Todo>, response: Response<Todo>) {
//                if (response.isSuccessful){
//                    val todo = response.body() as Todo
//                    val tl = todo.data
//                    for (i in tl){
//                        Log.e("todo",i.task)
//                    }
//                }
//            }
//
//        })
//        gh.addTodo("Hello Fuck U All")
//            .enqueue(object :Callback<AddTodo>{
//                override fun onFailure(call: Call<AddTodo>, t: Throwable) {
//                    Log.e("addtodo",t.message.toString())
//                }
//
//                override fun onResponse(call: Call<AddTodo>, response: Response<AddTodo>) {
//                    val ad = response.body()!!
//                    val a = ad.data as Data2
//                    Log.e("addtodo",a.insertId.toString())
//                }
//
//            })

    }
}
