package com.example.simpleblog.model

data class DeleteTodo(
    val data: Data3,
    val error: Boolean,
    val message: String
)

data class Data3(
    val affectedRows: Int,
    val changedRows: Int,
    val fieldCount: Int,
    val insertId: Int,
    val message: String,
    val protocol41: Boolean,
    val serverStatus: Int,
    val warningCount: Int
)