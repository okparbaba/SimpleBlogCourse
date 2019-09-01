package com.example.simpleblog.model

data class AddTodo(
    val data: Data2,
    val error: Boolean,
    val message: String
)

data class Data2(
    val affectedRows: Int,
    val changedRows: Int,
    val fieldCount: Int,
    val insertId: Int,
    val message: String,
    val protocol41: Boolean,
    val serverStatus: Int,
    val warningCount: Int
)