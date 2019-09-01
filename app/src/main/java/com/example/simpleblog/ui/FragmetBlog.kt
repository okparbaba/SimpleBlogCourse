package com.example.simpleblog.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simpleblog.R
import com.example.simpleblog.model.Data
import com.example.simpleblog.model.Todo
import com.example.simpleblog.network.RetrofitHelper.Companion.getRetrofit
import com.example.simpleblog.network.TodoService
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_fragmet_blog.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FragmetBlog : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragmet_blog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getRetrofit<TodoService>().getTodos()
            .enqueue(object:Callback<Todo>{
                override fun onFailure(call: Call<Todo>, t: Throwable) {
                    Toast.makeText(activity,t.message.toString(),Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<Todo>, response: Response<Todo>) {
                    if (response.isSuccessful){
                        val todo = response.body()!!
                        val data = todo.data
                        rvBlog.layoutManager = LinearLayoutManager(activity)
                        rvBlog.adapter = BlogAdapter(data,activity!!)
                        for (i in data)
                        Log.e("todo",i.task)
                    }
                }

            })
    }

}
