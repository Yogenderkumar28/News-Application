package com.example.newsapplication.services

import com.example.newsapplication.models.News
import okio.IOException

class NewsRepository {
    suspend fun getNews(country: String, apiKey: String): List<News> {
        val response = NewsInstance.newsApi.getNews(country, apiKey)
        if(response.isSuccessful) {
            val newsResponse = response.body()
            return newsResponse?.articles?: emptyList()
        }
        else {
            throw IOException("Error getting top headlines : ${response.code()}")
        }
    }
}