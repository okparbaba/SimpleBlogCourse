package com.example.simpleblog.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleblog.R
import com.example.simpleblog.model.Data
import kotlinx.android.synthetic.main.blog_item.view.*

class BlogAdapter(val items:List<Data>,val ctx:Context):RecyclerView.Adapter<BlogAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
        ViewHolder(LayoutInflater.from(ctx).inflate(R.layout.blog_item,parent,false))

    override fun getItemCount()=items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.task.text = items[position].task
        holder.time.text = items[position].created_at
    }

    class ViewHolder(v:View):RecyclerView.ViewHolder(v) {
        val task = v.tvTask
        val time = v.tvTime
    }

}