package com.example.simpleblog.network

import com.example.simpleblog.model.AddTodo
import com.example.simpleblog.model.DeleteTodo
import com.example.simpleblog.model.Todo
import retrofit2.Call
import retrofit2.http.*

interface TodoService {
    @GET("todos")
    fun getTodos():Call<Todo>

    @FormUrlEncoded
    @POST("todo")
    fun addTodo(@Field("task") t:String):Call<AddTodo>

    @DELETE("/todo/{id}")
    fun deleteTodo(@Path("id")id:Int):Call<DeleteTodo>


}