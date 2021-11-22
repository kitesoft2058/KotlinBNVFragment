package com.kitesoft.kotlinbnvfragment

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MyAdapter constructor(val context:Context, var items: List<ShoppingItem>) : RecyclerView.Adapter<MyAdapter.VH>() {

    inner class VH constructor(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tv:TextView = itemView.findViewById(R.id.tv_title)
        val iv:ImageView = itemView.findViewById(R.id.iv)

        fun bind(item:ShoppingItem){
            tv.text= item.title
            Glide.with(context).load(item.image).into(iv)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val itemView:View= LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false)
        return VH(itemView)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(items.get(position))
        holder.itemView.setOnClickListener {
            //val intent: Intent = Intent(context, MainActivity::class.java)
            //context.startActivity(intent)
            AlertDialog.Builder(context).setMessage( "position : ${position}" ).show()

        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}