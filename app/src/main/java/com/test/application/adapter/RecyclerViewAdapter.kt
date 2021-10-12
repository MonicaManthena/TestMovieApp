package com.test.application.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.test.application.R
import com.test.application.data.MovieDetail
import kotlinx.android.synthetic.main.list_item.view.*

class RecyclerViewAdapter(val movieDetail: List<MovieDetail>)
    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Picasso.get().load(movieDetail[position].poster).into(holder.image);
        holder.title.text = "Title: "+movieDetail[position].title
        holder.year.text = "Year: "+ movieDetail[position].year
    }

    override fun getItemCount(): Int {
        return movieDetail.size
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image : ImageView = itemView.image
        val title: TextView = itemView.title
        val year: TextView = itemView.year
    }
}