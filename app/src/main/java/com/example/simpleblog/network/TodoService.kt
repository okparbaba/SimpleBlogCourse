package com.example.simpleblog.network

import com.example.simpleblog.model.Todo
import retrofit2.Call
import retrofit2.http.GET

interface TodoService {
    @GET("todos")
    fun getTodos():Call<Todo>

}