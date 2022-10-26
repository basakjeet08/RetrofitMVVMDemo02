package com.example.retrofitmvvmdemo02.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitmvvmdemo02.R
import com.example.retrofitmvvmdemo02.model.ArticleData
import com.squareup.picasso.Picasso

class NewsApiAdapter : RecyclerView.Adapter<NewsApiAdapter.ViewHolder>() {

    private var articles : ArrayList<ArticleData> = ArrayList()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvId: TextView = itemView.findViewById(R.id.tvId)
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvAuthor: TextView = itemView.findViewById(R.id.tvAuthor)
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val tvDescription: TextView = itemView.findViewById(R.id.tvDescription)
        val tvContent: TextView = itemView.findViewById(R.id.tvContent)
        val tvPublishedAt: TextView = itemView.findViewById(R.id.tvPublishedAt)
        val ivImage: ImageView = itemView.findViewById(R.id.ivImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news_row , parent , false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val news = articles[position]
        if (news.source?.id != null)
            holder.tvId.append(" ${news.source.id}")
        else
            holder.tvId.append(" None")
        if (news.source?.name != null)
            holder.tvName.append(" ${news.source.name}")
        else
            holder.tvName.append(" None")
        if (news.author != null)
            holder.tvAuthor.append(" ${news.author}")
        else
            holder.tvAuthor.append(" None")
        if (news.title != null)
            holder.tvTitle.append(" ${news.title}")
        else
            holder.tvTitle.append(" None")
        if (news.description != null)
            holder.tvDescription.append(" ${news.description}")
        else
            holder.tvDescription.append(" None")
        if (news.content != null)
            holder.tvContent.append(" ${news.content}")
        else
            holder.tvContent.append(" None")
        if (news.publishedAt != null)
            holder.tvPublishedAt.append(" ${news.publishedAt}")
        else
            holder.tvPublishedAt.append(" None")
        if (news.urlToImage != null)
            Picasso.get().load(news.urlToImage).into(holder.ivImage)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    fun updateList(newList : ArrayList<ArticleData>){
        articles = newList
        notifyDataSetChanged()
    }
}