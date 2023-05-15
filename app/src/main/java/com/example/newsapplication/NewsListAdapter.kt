package com.example.newsapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapplication.models.News
import com.squareup.picasso.Picasso

class NewsListAdapter(private val newsItems: List<News>): RecyclerView.Adapter<NewsListAdapter.viewHolder>() {

    inner class viewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.news_title)
        val content: TextView = itemView.findViewById(R.id.news_content)
        val image: ImageView = itemView.findViewById(R.id.news_image)
        val publishedAt :TextView = itemView.findViewById(R.id.news_publishedAt)

        fun bind(newsItem: News) {
            title.text = newsItem.title
            content.text = newsItem.content
            publishedAt.text = newsItem.publishedAt
            Picasso.get().load(newsItem.urlToImage).into(image)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        return viewHolder(view)
    }

    override fun getItemCount(): Int {
        return newsItems.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val newsItem = newsItems[position]
        holder.bind(newsItem)
    }
}