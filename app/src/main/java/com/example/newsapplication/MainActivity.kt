package com.example.newsapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapplication.databinding.ActivityMainBinding
import com.example.newsapplication.models.News
import com.example.newsapplication.services.NewsApi
import com.example.newsapplication.services.NewsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// const val API_KEY = "f27008ce99ca4ee98f73ff93c39c4a75"

class MainActivity : AppCompatActivity() {
    private val API_KEY = "f27008ce99ca4ee98f73ff93c39c4a75"
    val mbinding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var recyclerView: RecyclerView
    private lateinit var newsAdapter : NewsListAdapter
    private var repository =  NewsRepository()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mbinding.root)
        recyclerView = mbinding.recyclerViewNews

        CoroutineScope(Dispatchers.Main).launch {
            try {
                val articles = repository.getNews("us", API_KEY)
                newsAdapter = NewsListAdapter(articles)
                recyclerView.adapter = newsAdapter
                recyclerView.layoutManager = LinearLayoutManager(parent)

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        
    }
}