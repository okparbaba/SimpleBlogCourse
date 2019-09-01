package com.example.simpleblog.model

data class Todo(
    val data: List<Data>,
    val error: Boolean,
    val message: String
)

data class Data(
    val created_at: String,
    val id: Int,
    val status: Int,
    val task: String
)
